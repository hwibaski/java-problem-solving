## Java 형변환

### String -> 숫자형(int, double, float, long short)

```java
String sNum = "1234";

int i1 = Integer.parseInt(sNum);
int i2 = Integer.valueOf(sNum);

double d1 = Double.parseDouble(sNum);
double d2 = Double.valueOf(sNum);

float f1 = Float.parseFloat(sNum);
float f2 = Float.valueOf(sNum);
 
long l1 = Long.parseLong(sNum);
long l2 = Long.valueOf(sNum);

short s1 = Short.parseShort(sNum);
short s2 = Short.valueOf(sNum);
```

### 숫자형 -> String
```java
int i = 1234;
String i1 = String.valueOf(i);
String i2 = Integer.toString(i);

double d = 1.23;
String d1 = String.valueOf(d);
String d2 = Double.toString(d);


float f = 1.23;
String f1 = String.valueOf(f);
String f2 = Float.toString(f);

long l = 1234L;
String l1 = String.valueOf(l);
String l2 = Long.toString(l);


short s = 1234;
String s1 = String.valueOf(s);
String s2 = Short.toString(s);
```