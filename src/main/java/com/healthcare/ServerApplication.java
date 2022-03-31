package com.healthcare;

import com.healthcare.dao.QuestionnaireFlowDao;
import com.healthcare.dao.QuestionnaireFlowWithCountDao;
import com.healthcare.dao.QuestionnaireFlowWithoutCountDao;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Brain Health Initiative API", version = "1.0"))
@SecurityScheme(name = "Brain Health Initiative API", scheme = "bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class ServerApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ServerApplication.class, args);
        QuestionnaireFlowDao questionnaireFlowWithCountDaoDao = configurableApplicationContext.getBean(QuestionnaireFlowWithCountDao.class);
        QuestionnaireFlowDao questionnaireFlowWithoutCountDaoDao = configurableApplicationContext.getBean(QuestionnaireFlowWithoutCountDao.class);
    }

}
