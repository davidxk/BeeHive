byte gsmDriverPin[2] = { 2, 3 };
unsigned char PhoneNum[24]={"AT+CMGS=\"13713748873\""};
String output;

// Gas Dht
#include <dht11.h>
dht11 DHT11;
#define DHT11PIN 1

// CO1
int gas_din = 0;
int gas_ain = A0;
int co1_value;

// Noise
int sound_din=1;
int sound_ain=A1;
int noi_value;

// Ultrviolet
int uv_ain=A2;
int ult_value;


void connect()
{
	delay(5000);
	char i;
	Serial.println("AT+SAPBR=3,1,\"CONTYPE\",\"GPRS\"");
	delay(500);
	Serial.println("AT+SAPBR=3,1,\"APN\",\"cmnet\"");
	delay(500);
	Serial.println("AT+SAPBR=1,1");
	delay(7000);
	Serial.println("AT+HTTPINIT");
	delay(500);
}

void setup()
{
	// Init the driver pins for GSM function
	for(int i = 0 ; i < 2; i++)
		pinMode(gsmDriverPin[i], OUTPUT);
	digitalWrite(2,LOW);//Enable the GSM mode 
	digitalWrite(3,HIGH);//Disable the GPS mode
	delay(200);
	Serial.begin(115200); //set the baud rate
	delay(1000);//call ready

	// GAS DHT
	pinMode(gas_din,INPUT);
	pinMode(gas_ain,INPUT);

	// Noise
	pinMode(sound_din,INPUT);
	pinMode(sound_ain,INPUT);

	// Ultrviolet
	pinMode(uv_ain,INPUT);

	connect();
}

void loop()
{
	// Get data from sensor
	// Temperature and Humidity
	int chk = DHT11.read(DHT11PIN);
	// Gas Dht
	co1_value = analogRead(gas_ain);
	// Noise
	noi_value = analogRead(sound_ain);
	// Ultrviolet
	ult_value=analogRead(uv_ain);
      // Phone Number
	const long pho_value = 111;
	

	// Make http request
	String post = "AT+HTTPPARA=\"URL\",\"http://1.waspwo.applinzi.com/servlet/SaveAction?";
	Serial.print(post);

	const int n_key = 7;
	delay(500);
	String keys[] = { "pho", "co1", "tem", "hum", "noi", "ult" };
	long vals[] = { pho_value, co1_value, DHT11.temperature,
			DHT11.humidity, noi_value, ult_value };
	for(int i=0; i<n_key; i++)
	{
		if(i != 0)
			Serial.print("&");
		Serial.print(keys[i]+"=");
		Serial.print(vals[i]);
	}
	Serial.println("\"");
	delay(500);
	// Send request to server
	Serial.println("AT+HTTPACTION=0");
	delay(5000);
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
