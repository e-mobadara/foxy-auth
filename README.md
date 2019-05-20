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
	        implementation 'com.github.e-mobadara:foxy-auth:v0.2.2'
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

        gameStat.setApp_id("a");
        gameStat.setExercise_id("a");
        gameStat.setLevel_id("a");
        gameStat.setUpdated_at("a");
        gameStat.setCreated_at("a");
        gameStat.setSuccessful_attempts("a");
        gameStat.setFailed_attempts("a");
        gameStat.setMin_time_succeed_sec("a");
        gameStat.setAvg_time_succeed_sec("a");
        gameStat.setLongitude("a");
        gameStat.setLatitude("a");
        FoxyAuth.storeGameStat(this,gameStat);
```
## Having an issue?
please Open an issue in the Issue tab and provide a way to reproduce the bug. A link to your repo would be nice.Or even a code snippet. We are counting on your collaboration. 
