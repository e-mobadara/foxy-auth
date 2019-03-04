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
	        implementation 'com.github.e-mobadara:foxy-auth:v0.2.0-beta'
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

## Having an issue?
please Open an issue in the Issue tab and provide a way to reproduce the bug. A link to your repo would be nice.Or even a code snippet. We are counting on your collaboration. 
