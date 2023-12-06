# Spring Context Lifecycle

Understanding the lifecycle is crucial for proper initialization and cleanup of resources in a Spring application. This
module serves as a guide to various lifecycle-related annotations and interfaces, providing insights into the lifecycle
phases.

## Lifecycle Annotations and Interfaces

### 1. **`@PostConstruct` and `@PreDestroy` Annotations**

The `@PostConstruct` and `@PreDestroy` annotations are used to define methods that should be executed after bean
construction and before bean destruction, respectively. For example:

```java
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class MyLifecycleBean {

    @PostConstruct
    public void init() {
        // Initialization logic
    }

    @PreDestroy
    public void cleanUp() {
        // Cleanup logic
    }

    // ... rest of the code
}
```

### 2. `InitializingBean` and `DisposableBean` Interfaces

The `InitializingBean` and `DisposableBean` interfaces provide methods (`afterPropertiesSet` and `destroy`,
respectively) that
can be implemented by beans to perform initialization and cleanup tasks:

```java
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class MyInitializingDisposableBean implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        // Initialization logic
    }

    @Override
    public void destroy() throws Exception {
        // Cleanup logic
    }

    // ... rest of the code
}
```

### 3. `BeanNameAware` Interface

The `BeanNameAware` interface allows a bean to obtain its own bean name during initialization:

```java
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class MyBeanNameAwareBean implements BeanNameAware {

    private String beanName;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    // ... rest of the code
}
```

### 4. `BeanPostProcessor` Interface

The `BeanPostProcessor` interface provides hooks for customizing bean instantiation and initialization. It includes
methods like `postProcessBeforeInitialization` and `postProcessAfterInitialization`. For example:

```java
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // Custom logic before bean initialization
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // Custom logic after bean initialization
        return bean;
    }

    // ... rest of the code
}
```

### 5. Additional Annotations and Interfaces

Explore other notable annotations and interfaces related to the Spring bean lifecycle:

E.g.

#### `Aware` interfaces:

- **`BeanFactoryAware`**: Allows a bean to be aware of the `BeanFactory` that created it.
- **`ApplicationContextAware`**: Allows a bean to be aware of the `ApplicationContext` in which it is running.
- **`EnvironmentAware`**: Allows a bean to access the environment in which it is deployed.
- **`MessageSourceAware`**: Allows a bean to access the message source for resolving messages.
- **`ApplicationEventPublisherAware`**: Allows a bean to publish application events.
- **`ResourceLoaderAware`**: Allows a bean to access the resource loader.
- **`ServletContextAware`**: Allows a bean to be aware of the `ServletContext` in which it is running.
- **`LoadTimeWeaverAware`**: Allows a bean to be aware of the `LoadTimeWeaver` for class instrumentation.
- **`NotificationPublisherAware`**: Allows a bean to access a notification publisher for sending JMX notifications.
- **`PortletConfigAware`**: Allows a bean to be aware of its `PortletConfig` configuration.
- **`PortletContextAware`**: Allows a bean to be aware of its `PortletContext`.

#### Annotations:

- `@Lazy`: Delays the initialization of a bean until it is actually requested.
- `@DependsOn`: Specifies the bean names that this bean depends on.