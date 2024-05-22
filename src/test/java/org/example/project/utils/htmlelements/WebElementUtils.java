package org.example.project.utils.htmlelements;

import org.example.project.ui.htmlelements.annotations.Name;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;

public class WebElementUtils {
    public static String getElementName(WebElement element) {
        try {
            Field field = element.getClass().getDeclaredField("decoratedElement");
            field.setAccessible(true);
            WebElement decoratedElement = (WebElement) field.get(element);

            Name nameAnnotation = decoratedElement.getClass().getDeclaredAnnotation(Name.class);
            if (nameAnnotation != null) {
                return nameAnnotation.value();
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }
        return null;
    }
}
