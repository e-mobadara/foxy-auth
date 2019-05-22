# Android FoxyAuth

FoxyAuth is a library that generates an E-Mobadara authentication page for .

## Requirements
- minSdkVersion 17+
- compileSdkVersion 26


## How to

### Step 1. Add the JitPack repository to your build file

```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

### Step 2. Add the dependency
```
dependencies {
	        implementation 'com.github.e-mobadara:foxy-auth:v0.2.3'
	}
```

## Usage
In your main main activity use the following line after
```
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        FoxyAuth.emerge(this,MainActivity.class);
```

Replace MainActivity with the first activity that runs on your App.

## Adding new game stat (Game_Infos)
to store a new game registry you can create an instance of the object GameStat

```
        GameStat gameStat = new GameStat();


        gameStat.setApp_id("2018_3_3_4");
        gameStat.setExercise_id("T_6_20");
        gameStat.setLevel_id("1");
        gameStat.setUpdated_at("2019-05-10 23:38:31");
        gameStat.setCreated_at("2019-05-10 23:40:00");
        gameStat.setSuccessful_attempts("1");
        gameStat.setFailed_attempts("11");
        gameStat.setMin_time_succeed_sec("50");
        gameStat.setAvg_time_succeed_sec("58");
        gameStat.setLongitude("11.2555");
        gameStat.setLatitude("-2.55547");


        FoxyAuth.storeGameStat(this,gameStat);
```
## Having an issue?
please Open an issue in the Issue tab and provide a way to reproduce the bug. A link to your repo would be nice.Or even a code snippet. We are counting on your collaboration. 
