# Newsum 
협업 인원: 3명 (API Server 및 배포 기여도 100%)                
2022.01 ~ 진행중 
***********************************
## 🌳소개
뉴스 기사를 언론사 별로 요약해서 찾아보기가 쉽지 않고 관심있는 주제와 관련된 기사들을 아카이브해서 볼 수 있는 방식이 한정적이라는 점에서 뉴스 기사에 대한 현대인의 접근성이 많이 떨어진다고 느꼈습니다. 이러한 문제점에서 출발하여 Newsum 서비스는 중앙일보, 한겨레, 경향신문 세 언론사의 기사를 각 정치, 경제, 사회 분야로 나누어 3줄요약된 실시간 인기 기사를 보여줍니다. 또한 유저가 기사 내에 직접 제시된 단어가 아니더라도 관련된 주제 키워드를 검색하여 찾고자 하는 주제의 기사에 접근할 수 있도록 기사마다 카테고리를 붙여 보다 구체화된 카테고리 검색 기능을 제공합니다.
아직 구현되지는 않았지만 추후에 유저 계정별 운영을 지원할 예정이며 유저 별로 관심 있는 기사 아카이브 및 기록, 기사에 대한 커뮤니케이션이 가능하도록 구현할 예정입니다. 

## 🌳시스템 구성도
### System Architecture
![image](https://user-images.githubusercontent.com/84822464/160995716-8f5d8824-4977-432d-bc9b-beacf119d012.png)
### 배포 전체 구조 
![image](https://user-images.githubusercontent.com/84822464/160999323-1f3c9026-e56c-4e99-bc8b-e2ac1566a704.png)

## 🌳환경 
## 🌷 API Server 개발 환경
AWS RDS for MariaDB(RDB), Spring Boot(API Server)
## 🌳Using
SpringBoot, Gradle(Build Tool), Spring Data JPA, QueryDSL, MariaDB(RDB), Java 8(Language), IntelliJ IDEA

## 🌳주요 기능 
![image](https://user-images.githubusercontent.com/84822464/160994696-50989e70-e1a4-429e-a848-adf25d88f115.png)


