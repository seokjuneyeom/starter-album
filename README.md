# starter-clone


# session1 : standard

- 기본적인 Singer, Song, Album 3개 객체의 구조로써 각 서비스에 대한 간단한 테스트 코드 작성
- OAS 를 적용하지 않고, Entity 와 DTO 등을 직접 작성 및 테스트

# session2 : OAS

- 1에서 진행한 부분에 DTO 를 전부 OpenApi Generator 를 통해 만들어지도록 수정
- Swagger 빌드 추가
- Entity <-> DTO 간 transform 을 간편하게 하기 위해 mapStruct 추가

# session3 : DB connection

- 도커를 이용해 DB 컨테이너 생성
- 해당 컴포즈 파일을 빌드하기 위한 docker.gradle 파일 생성
