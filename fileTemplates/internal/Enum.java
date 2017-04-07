#parse("Copyright.java")
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

#parse("File Header.java")
public enum ${NAME} {

    ;
    
    private int value;
    
    private String name;
    
    ${NAME}(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static ${NAME} findByInt(int value) throws IllegalArgumentException {
        for (${NAME} item: ${NAME}.values()) {
            if (item.value == value) {
                return item;
            }
        }
        
        throw new IllegalArgumentException("Invalid ${NAME} value: " + value);
    }

    @JsonCreator
    public static ${NAME} findByString(String name) throws IllegalArgumentException {
      for (${NAME} item: ${NAME}.values()) {
            if (item.name.equals(name)) {
                return item;
            }
        }
        
        throw new IllegalArgumentException("Invalid ${NAME} name: " + name);
    }

    @JsonValue
	@Override
    public String toString() {
        return this.name;
    }
    
    public int toInt() {
        return this.value;
    }
}

