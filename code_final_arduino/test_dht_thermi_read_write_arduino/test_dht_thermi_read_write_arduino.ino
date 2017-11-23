#include <math.h>
#include <Adafruit_Sensor.h>
#include <DHT.h>
#include "thermistance.h"
#include "send.h"
#include "calcdht.h"

#define PELTIER 3
//Variables
int chk;
double celsius;
float consigne;
double V_IN = 5.0; //Alimentation électrique

int power = 0;
int peltier_level = map(power, 0, 99, 0, 255);

float valuedht[] = {0,0,0};

void setup() {
  Serial.begin(9600);
  InitDHT();
}

void loop() {

  CalculDHT(V_IN, valuedht);
  
  celsius = CalculTemp(V_IN, &valuedht[0]);
  SendData(celsius, valuedht[1], valuedht[0]);
  consigne = CastData();
  
  if(consigne >= valuedht[1]) {
  power = 0;
  }

  else {
  power = 99;
  }

  peltier_level = map(power, 0, 99, 0, 255);

  analogWrite(PELTIER, peltier_level); //Ecrit cette nouvelle valeur dans le port
  //delay(1000);
}
