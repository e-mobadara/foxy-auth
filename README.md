# Android FoxyAuth

FoxyAuth is a library that generates an E-Mobadara authentication page for .

## Requirements
- minSdkVersion 16+
- compileSdkVersion 28


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
	        implementation 'com.github.younesnajjar:foxy-auth:v0.2.0-beta'
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
