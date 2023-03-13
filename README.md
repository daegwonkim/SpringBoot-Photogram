# Photogram(Instagram Clone Coding)
### 1. 프로젝트 개요
- 프로젝트 명칭: Photogram
- 프로젝트 소개: 스프링부트를 활용한 인스타그램 클론 코딩 웹페이지
- 개발 인원: 1명
- 주요 기능
	- 폼 로그인 / OAuth 2.0 페이스북 로그인 기능
	- 게시글(사진) 업로드
	- 해시태그 기능
	- 게시글 및 사용자 검색 기능
	- 사용자 프로필, 닉네임, 비밀번호 등 회원정보 수정 기능
	- 사용자 구독 기능
	- 게시글 좋아요 및 댓글 기능
	- 새로운 글 업로드에 따른 구독자 실시간 알림 기능
	- 연관 검색어 기능
- 백엔드 개발 언어: Java
- 백엔드 개발 환경
	- Windows
	- STS4
	- SpringBoot
	- Spring Data JPA
	- Spring Security
	- OAuth 2.0
- 프론트 개발 언어 및 환경
	- HTML5
	- jQuery
	- JavaScript
	- Bootstrap
	- JSTL
- DBMS: MariaDB

<hr>

### 2. 프로젝트 요구사항
- 폼 로그인 및 OAuth 2.0 페이스북 로그인 기능
- 회원가입 시 유효성 검사
- 게시글(사진) 업로드
- 해시태그 추가 기능
- 게시글 및 사용자 검색 기능
- 연관 검색어 기능
- 댓글 및 좋아요 기능
- 구독자 실시간 알림 기능

#### 회원기능
> - 회원가입 시 유효성 검사를 통과해야 한다.
> - 폼 로그인 및 OAuth 2.0 페이스북 로그인 기능을 사용할 수 있어야 한다.
> - 프로필 사진, 닉네임, 비밀번호, 이메일 등의 정보를 수정할 수 있어야 한다.

<br>

#### 게시글 기능
> - 사진과 함께 게시글 업로드가 가능해야 한다.
> - 게시글 업로드 시 해시태그를 추가할 수 있어야 한다.
> - 게시글에 댓글을 작성하거나 좋아요를 표시할 수 있어야 한다.

<br>

#### 검색 기능
> - 사용자 이름을 통한 사용자 프로필 검색이 가능해야 한다.
> - 해시태그를 통한 게시글 검색이 가능해야 한다.
> - 사용자 또는 게시글 검색 시 연관 검색어 기능을 제공해주어야 한다.

<br>

#### 알림 기능
> - 자신이 구독한 사용자에 대한 실시간 알림을 받을 수 있어야 한다.

<hr>

### 3. DB 설계


<hr>

### 4. API 설계


<hr>

### 5. 개발 내용
1. [[Photogram] 회원가입 - Security 설정](https://daegwonkim.tistory.com/341)
2. [[Photogram] 회원가입 - 데이터베이스 저장](https://daegwonkim.tistory.com/342)
3. [[Photogram] 회원가입 - Validation](https://daegwonkim.tistory.com/343)
4. [[Photogram] 회원가입 - 공통 응답 DTO, Script 만들기](https://daegwonkim.tistory.com/344)
5. [[Photogram] 로그인](https://daegwonkim.tistory.com/345)
6. [[Photogram] 회원정보 수정](https://daegwonkim.tistory.com/346)
7. [[Photogram] 구독하기](https://daegwonkim.tistory.com/347)
8. [[Photogram] 프로필 페이지 - 서버에 이미지 업로드](https://daegwonkim.tistory.com/348)
9. [[Photogram] 프로필 페이지 - DB에 이미지 업로드](https://daegwonkim.tistory.com/349)
10. [[Photogram] 프로필 페이지 - 뷰 렌더링](https://daegwonkim.tistory.com/350)
11. [[Photogram] 구독하기 - 뷰 렌더링](https://daegwonkim.tistory.com/351)
12. [[Photogram] 구독하기 - 구독 모달](https://daegwonkim.tistory.com/353)
13. [[Photogram] 스토리 페이지](https://daegwonkim.tistory.com/354)
14. [[Photogram] 좋아요 구현하기](https://daegwonkim.tistory.com/355)
15. [[Photogram] 인기 페이지 구현](https://daegwonkim.tistory.com/356)
16. [[Photogram] 프로필 사진 변경](https://daegwonkim.tistory.com/357)
17. [[Photogram] 댓글 구현](https://daegwonkim.tistory.com/358)
18. [[Photogram] 유효성 검사 자동화 - AOP 처리](https://daegwonkim.tistory.com/359)
19. [[Photogram] OAuth2 페이스북 로그인](https://daegwonkim.tistory.com/360)
20. [[Photogram] 검색 기능 구현](https://daegwonkim.tistory.com/376)
21. [[Photogram] 로그인 실패 처리](https://daegwonkim.tistory.com/377)
22. [[Photogram] 해시태그 기능 추가](https://daegwonkim.tistory.com/378)
23. [[Photogram] 실시간 알림](https://daegwonkim.tistory.com/379)
24. [[Photogram] 연관 검색어](https://daegwonkim.tistory.com/380)

<hr>

### 6. 실행 화면
<details>
<summary>사용자 관련</summary>

#### 로그인 및 로그아웃 페이지


#### 로그인에 실패할 경우


#### 회원가입 페이지


#### 회원가입에 실패한 경우


#### 사용자 프로필 페이지


#### 회원정보 수정 페이지

</details>

<details>
<summary>게시글 관련</summary>

#### 스토리 페이지


#### 게시글 업로드 페이지

</details>

<details>
<summary>검색 관련</summary>

#### 연관 검색어 기능


#### 사용자 검색 페이지


#### 게시글 검색 페이지

</details>

<hr>

### 7. 프로젝트 후기
