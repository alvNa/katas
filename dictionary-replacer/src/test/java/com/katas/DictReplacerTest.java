package com.katas;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import java.util.Map;

/**
 * Tests
 *
 * input : “”, dict empty, output:“”
 *
 * input : “\$temp\$“, dict [“temp”, “temporary”], output: “temporary”
 *
 * input : “\$temp\$ here comes the name \$name\$“, dict [“temp”, “temporary”] [“name”, “John Doe”], output : “temporary here comes the name John Doe”
 * */
@DisplayName("Dictionary replacer tests")
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DictReplacerTest {

    //@Mock
    static private DictReplacer dictReplacer;

    @BeforeAll
    static void init() {
        dictReplacer = new DictReplacer();
    }

    @Test
    @DisplayName("Return a empty ootput value")
    void shouldReplaceEmpty(){
        assertEquals("", dictReplacer.replace("", Map.of()));
    }

    @Test
    void shouldReplaceWithPreAndSuf(){
         assertEquals("temporary", dictReplacer.replace("$temp$", Map.of("temp","temporary")));
    }

    @Test
    void shouldReplaceTwo() {
        var result = dictReplacer.replace("$temp$ here comes the name $name$",
                Map.of("temp","temporary","name","John Doe"));
        assertEquals("temporary here comes the name John Doe", result);
    }
}
