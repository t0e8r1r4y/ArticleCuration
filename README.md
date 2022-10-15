# :star2: ArticleCuration

이전 프로젝트 : [Notification Serivce](https://github.com/t0e8r1r4y/NaverAPI/blob/main/README.md)

> Naver API에서 조회한 블로그 Article 링크를 기반으로 페이지를 크롤링하여 콘텐츠 큐레이터 서비스를 만들어봅니다.
> 해당 프로젝트는 이전 프로젝트를 구현하면서 해결하고 싶은 문제와 고도화 하고 싶은 내용을 반영하여 이전 프로젝트에서 해당 기능을 분리하고자 합니다.

<br/>


## :star2: 프로젝트 목적

#### :white_check_mark: 해결하고 싶은 문제
- api 서버에서 보내주는 내용와 운영 서비스가 가지고 있는 데이터 간 데이터 일관성 불일치 문제 발생
- 일관성 불일치를 위해서 현재는 HashSet을 사용한 중복 제거만을 사용하고 있음. 그리고 이전 데이터를 조회하기 위해서 빈번하게 DB를 조회하고 있어 로컬 캐시를 적용함
- 위 문제를 해결하는 옵션을 다양하게 가져가고 싶음 ( 파티셔닝 테이블 설계, 삭제나 업데이트 플래그를 추가한 관리 등등 )

<br/>

#### :white_check_mark: 고도화 하고 싶은 부분
- 사용자가 입력한 키워드와 해당 article이 얼마나 연관성이 있는지를 확인하여, 관련 아티클을 제공하는 방향으로 서비스 고도화의 필요성을 느낌.

<br/>

> 상세 내용은 [wiki](https://github.com/t0e8r1r4y/ArticleCuration/wiki/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EB%AA%A9%EC%A0%81)에 정리
