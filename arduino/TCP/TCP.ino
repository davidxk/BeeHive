byte gsmDriverPin[2] = { 2, 3 };
unsigned char PhoneNum[24]={"AT+CMGS=\"13713748873\""};
String output;



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
	Serial.println("AT+CSTT=\"CMNET\"");
	delay(500);
	Serial.println("AT+CIICR");
	delay(2000);
	Serial.println("AT+CIFSR");
	delay(500);
	Serial.println("AT+CDNSGIP=\"t.tt\"");
	delay(500);
	Serial.println("AT+CIPSTART=\"TCP\",\"t.tt\",\"80\"");
	delay(2000);
	Serial.println("AT+CIPSEND");
	delay(500);
	Serial.println("An Http Post command");
	delay(500);
	Serial.write(26);
	//Add print here!
	while(1);
}

/*
String buffer;
while(Serial.available())
{
char ch = readChar();
if(ch == 'A' or ch == 'a')
ch = '@';
// Add ch to buffer
buffer += ch;
if(ch == '\n')
{
buffer += '#';
if(buffer.startsWith("#"))
continue;
else
Serial.print(buffer);
// Clear buffer
buffer = "";
}
}
*/
