# Selenium Alert Handling

This snippet demonstrates how to handle JavaScript alerts in Selenium WebDriver.

## Accept the Alert
```java
Alert alertOff = driver.switchTo().alert();
alertOff.accept();
```

## Example Code

```java
// Switch to the alert
Alert alert = driver.switchTo().alert();

// Get the text from the alert
String alertText = alert.getText();
Assert.assertEquals("Hello world!", alertText);

// Accept the alert (clicks OK)
alert.accept();
```
