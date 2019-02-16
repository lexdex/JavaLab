import annotation.Description;
import model.ElectricalAppliance;
import util.ClassInfo;
import util.ReflectionHelper;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ElectricalAppliance appliance = new ElectricalAppliance("Toaster", 850);

        String[] stringArray1 = ReflectionHelper.findAnnotatedFieldNames(appliance, Description.class);
        String[] stringArray2 = ReflectionHelper.getFieldAnnotationValues(appliance, "name");

        Arrays.asList(stringArray1).forEach(System.out::println);
        Arrays.asList(stringArray2).forEach(System.out::println);

        ReflectionHelper.invokeMethod(appliance, "getPowerConsumption");

        ReflectionHelper.invokeMethod(appliance, "setPowerConsumption", 900);
        System.out.println(appliance.getPowerConsumption());

        ReflectionHelper.setFieldValue(appliance, "powerConsumption", 950);
        System.out.println(appliance.getPowerConsumption());

        ClassInfo.printInfo(appliance);
    }
}
