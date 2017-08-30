Sample Spring Boot Application with Securty and Social Integration
==================================================================

* Spring Social LinkedIn login with Persisted Connections
* Spring Security with SocialAuthenticationFilter
* Auto registering new logged user 
* Basic thymeleaf templates
* Password login disabled

Configuration
---

```yaml
spring:
  social:
    linkedin:
      appId: XXXXXXXXXXXXXX
      appSecret: XXXXXXXXXXXXXXXX

application.url: http://localhost:8080
```