package com.jjh.anno.importAnno.scan;

import com.jjh.anno.importAnno.ConfigurationA;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

//@Import(ConfigurationA.class)
@Import({ConfigurationB.class,ConfigurationC.class})
@Component
public class Customer {
}
