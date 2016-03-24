byte gsmDriverPin[2] = { 2, 3 };
unsigned char PhoneNum[24]={"AT+CMGS=\"13713748873\""};
String output;


char readChar()
{
	char ch = char(Serial.read());
	if(ch == 'A' or ch == 'a')
		ch = '@';
	output += ch;
	if(ch == '\n')
		output += '#';
	return ch;
}

bool is_OK_()
{
	int cnt = 0;
	int maxLines = 15;
	String buffer;

	while(cnt < maxLines)
	{
		if(Serial.available())
		{
			char ch = readChar();
			// Add ch to buffer
			buffer += ch;
			if(ch == '\n')
			{
				if(buffer.startsWith("OK"))
					return true;
				// Clear buffer
				buffer = "";
			}
		}
		cnt++;
	}
	return false;
}

void repeatIfNot_OK_(String cmd)
{
	int cnt = 0;
	int maxTimes = 10;
	do {
		Serial.println(cmd);
		delay(500);
		cnt++;
	}
	while(!is_OK_() && cnt<maxTimes);
}

bool isError(String cmd, String OKStr)
{
	int _OK_ = 1, _PENDING_ = 0, _ERROR_ = -1;
	int error = _PENDING_;

	while(Serial.available())
	{
		char ch = readChar();
		if(error != _PENDING_)
			continue;

		if(ch == OKStr[0])
		{
			for(int i=1; i<OKStr.length(); i++)
			{
				ch = readChar();
				if( ch != OKStr[i] )
					break;
				else if(i == OKStr.length()-1)
					error = _OK_;
			}
		}
		if(ch == 'E')
		{
			String buffer;
			buffer += ch;
			for(int i=0; i<4; i++)
				buffer += readChar();
			if( buffer.equals("ERROR") )
				error = _ERROR_;
		}
	}
	for(int i=0; i<20; i++)
	{
			while(Serial.available())
			readChar();
	}
	cmd[0] = '@';
	if(error == _ERROR_)
	{
		Serial.print("Error with command: ");
		Serial.println(cmd);
		return true;
	}
	else if(error == _OK_)
	{
		Serial.print("Success with: ");
		Serial.println(cmd);
		return false;
	}
	Serial.print("Success(I guess) with: ");
	Serial.println(cmd);
	return false;
}

void repeatIfError(String cmd, int delayTime = 500)
{
	int cnt = 0;
	int maxTimes = 10;
	do {
		Serial.println(cmd);
		delay(delayTime);
		cnt++;
	}
	while(isError(cmd, "OK") && cnt<maxTimes);
}

void repeatIfNotConOK(String cmd)
{
	int cnt = 0;
	int maxTimes = 10;
	do {
		Serial.println(cmd);
		delay(5000);
		cnt++;
	}
	while(isError(cmd, "CONNECT OK") && cnt<maxTimes);
}



void setup()
{
	//Init the driver pins for GSM function
	for(int i = 0 ; i < 2; i++)
		pinMode(gsmDriverPin[i], OUTPUT);
	digitalWrite(2,LOW);//Enable the GSM mode 
	digitalWrite(3,HIGH);//Disable the GPS mode
	delay(200);
	Serial.begin(115200); //set the baud rate
	delay(1000);//call ready
}

void loop()
{
	delay(5000);
	char i;
	//repeatIfError("AT+CSQ");
	repeatIfError("AT");

	repeatIfError("AT+CSTT=\"CMNET\"");
	repeatIfError("AT+CIICR", 2000);
	Serial.println("AT+CIFSR");
	delay(500);
	repeatIfError("AT+CDNSGIP=\"www.baidu.com\"", 3000);
	repeatIfNotConOK("AT+CIPSTART=\"TCP\",\"t.tt\",\"80\"");
	repeatIfError("AT+CIPSEND");
	Serial.println("An Http Post command");
	Serial.write(26);
	for(int i=0; i<20; i++)
	{
		delay(500);
		while(Serial.available())
			readChar();
	}
	Serial.print('#');
	Serial.print( output );
	while(1);
}