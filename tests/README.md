# Tests with Selenide

* [Selenide](http://selenide.org/)
* [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/)
* [Appium](http://appium.io/)

## Run tests (Browser)

Prepare

```console
# cd ..
# cordova platform add browser
cordova run browser
```

Run

```console
gradle -Dselenide.browser=provider.ChromeMobileEmulatorDriverProvider \
       -Dselenide.baseUrl=http://localhost:8000 \
       -Dwebdriver.chrome.driver=$HOME/chromedriver \
       test
```

## Run tests (Android)

Prepare

```console
# install
npm install -g appium
# run server
appium
```

Run

```console
gradle -Dselenide.browser=provider.AndroidDriverProvider test
```

