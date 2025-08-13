# Scheduler Develop
- Spring Boot 기반의 프로젝트입니다.
- 유저 등록, 일정 생성 / 조회 / 수정 / 삭제 기능이 있습니다.
- 간단한 인증 구조가 포함되어 있습니다.

## 기술 스택
- Java 17
- Spring Boot
- Lombok
- Spring Data JPA
- MySQL

## 패키지 구조
org.schedulerdevelop

├─ Controller

│  ├─ LoginController.java

│  ├─ SchedulerController.java

│  └─ UserController.java

├─ Dto

│  ├─ LoginRequest.java

│  ├─ LoginResponse.java

│  ├─ SchedulerRequest.java

│  ├─ SchedulerResponse.java

│  ├─ UserRequest.java

│  └─ UserResponse.java

├─ Entity

│  ├─ BaseEntity.java

│  ├─ Scheduler.java

│  └─ User.java

├─ Filter

│  ├─ FilterConfig.java

│  └─ LoginFilter.java

├─ Repository

│  ├─ SchedulerRepository.java

│  └─ UserRepository.java

└─ Service

   ├─ LoginService.java
   
   ├─ SchedulerService.java
   
   └─ UserService.java
   
## API 명세

1. 유저 API
   
기능	          |HTTP Method |	URL    |	                Request Body                  |   Response

회원 가입	      |   POST	   |  /signup  | { "email": "", "userName": "", "password": "" }  |	회원 가입에 성공하였습니다

로그인	          |   POST	   |  /login   | { "email": "", "password": "" }                  | 로그인에 성공하였습니다. (세션 저장)

로그아웃	          |   POST     |  /logout  | 	-	                                          | 204 No Content

사용자 생성	      |   POST	   |   /user   | { "email": "", "userName": "", "password": "" }  | UserResponse

전체 사용자 조회	  |    GET     |   /user   |    -	                                          | [UserResponse]

사용자 조회	      |    GET	   |/user/{id} | 	-	                                          | UserResponse

사용자 수정	      |    PUT	   |/user/{id} | { "email": "", "userName": "" }                  |	UserResponse

사용자 삭제	      |   DELETE   |/user/{id} |	-	                                          | 204 No Content

2. 일정 API

기능	          |HTTP Method |	URL    |	                Request Body                  |   Response

일정 생성	      |   POST	   |        /scheduler       | { "userId": 1, "title": "", "content": "" }   | SchedulerResponse

전체 일정 조회	  |    GET     |        /scheduler       |    -	                                         | [SchedulerResponse]

일정 조회	      |    GET	   | /scheduler/{scheduleId} |    -	                                         | SchedulerResponse

일정 수정	      |    PUT	   | /scheduler/{scheduleId} | { "title": "", "content": "" }                | SchedulerResponse

일정 삭제	      |   DELETE   | /scheduler/{scheduleId} |	  -	                                         | 200 OK

3. 예외 처리
   - 유저 없음 : "해당 유저가 없습니다."
   - 일정 없음 : "해당 일정이 없습니다."
   - 로그인 필요 : "로그인 해주세요."
   - 비밀번호 불일치 : "비밀번호가 일치하지 않습니다."
   - 이메일 없음 : "없는 E-mail입니다."
