# DBAPP

### 데이터베이스 생성 방법
```sql
create user 'korea'@'%' IDENTIFIED BY 'korea1234';
GRANT ALL PRIVILEGES ON *.* TO 'korea'@'%';
CREATE DATABASE koreadb;
```

### 더미데이터
```sql
INSERT INTO user(username, PASSWORD) VALUES('ssar', '1234');
INSERT INTO user(username, PASSWORD) VALUES('cos', '1234');

INSERT INTO post(title, content, user_id) VALUES('제목1', '내용1', 1);
INSERT INTO post(title, content, user_id) VALUES('제목2', '내용2', 1);
INSERT INTO post(title, content, user_id) VALUES('제목3', '내용3', 1);
INSERT INTO post(title, content, user_id) VALUES('제목4', '내용4', 2);
INSERT INTO post(title, content, user_id) VALUES('제목5', '내용5', 2);
```

### 추가 의존성 (DI)
```xml
<dependency>
    <groupId>org.apache.tomcat</groupId>
    <artifactId>tomcat-jasper</artifactId>
    <version>9.0.46</version>
</dependency>
```

```
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
</dependency>
```
### JSTL 태그 라이브러리
```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
```

### application.yml
```yml
server:
  port: 8000
  servlet:
    encoding:
      charset: UTF-8
      
spring:
  mvc:
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp
      
  datasource:
    driver-class-name: org.mariadb.jdbc.Driver
    username: korea
    password: korea1234
    url: jdbc:mysql://localhost:3306/koreadb
    
  jpa:
    hibernate:
      ddl-auto: none # create, update, none
    show-sql: true
```