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
![erd](https://user-images.githubusercontent.com/45421117/224655048-c56dbea0-b866-48f3-957c-4c5eef3ba129.png)

<hr>

### 4. API 설계
![user](https://user-images.githubusercontent.com/45421117/224662001-739bb666-50a8-4ce8-aaed-f21d21ac0c32.png)
![image](https://user-images.githubusercontent.com/45421117/224662112-49ce47a6-abdb-44bc-bffe-7b95e9cb2cb1.png)
![subscribe](https://user-images.githubusercontent.com/45421117/224662172-15f83989-f380-45e8-ab52-e3a72b93c46d.png)
![comment](https://user-images.githubusercontent.com/45421117/224662232-cd9b45df-62d9-4686-912a-ba0b37f2758c.png)
![search](https://user-images.githubusercontent.com/45421117/224662296-4615beec-77ac-414d-b393-d469d48c9dc1.png)
![notification](https://user-images.githubusercontent.com/45421117/224662361-8c1a6a31-95ee-477a-b072-fb769ccade08.png)

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
![login](https://user-images.githubusercontent.com/45421117/224647069-a230369b-8c5a-4309-b9b1-eef63fd1227c.png)

#### 로그인에 실패할 경우
![login_fail](https://user-images.githubusercontent.com/45421117/224647499-bf110f4d-a4f5-4b98-b25f-4ce2917dd431.png)

#### 회원가입 페이지
![join](https://user-images.githubusercontent.com/45421117/224647606-9ad73f70-a441-445b-bf6c-fb9a22fbc669.png)

#### 사용자 프로필 페이지
![profile](https://user-images.githubusercontent.com/45421117/224647824-05d2aaf4-9caa-41f6-9fd2-871311447933.png)

#### 회원정보 수정 페이지
![update](https://user-images.githubusercontent.com/45421117/224647926-81f15314-7d75-418f-afe8-f3b6de693cfb.png)
	
</details>

<details>
<summary>게시글 관련</summary>

#### 스토리 페이지
![story](https://user-images.githubusercontent.com/45421117/224648811-07641338-93ef-46b4-ae95-86c68e72a679.png)

#### 게시글 업로드 페이지
![upload](https://user-images.githubusercontent.com/45421117/224648917-d19f3268-03a5-41ef-854d-81731cac90e0.png)
	
</details>

<details>
<summary>검색 관련</summary>

#### 연관 검색어 기능
![relative](https://user-images.githubusercontent.com/45421117/224649162-57ac011e-1b7e-439c-8f1e-beb0b4e71459.png)

#### 사용자 검색 페이지
![account](https://user-images.githubusercontent.com/45421117/224649292-a013a247-f079-4d9d-8c7c-58029b97d56e.png)

#### 게시글 검색 페이지
![tag](https://user-images.githubusercontent.com/45421117/224649433-a1c1b16c-77fb-473c-af02-25d159252631.png)

</details>

<hr>

### 7. 프로젝트 후기
해당 프로젝트는 게시판 프로젝트 이후 새로운 프로젝트 주제를 고민하다가 찾은 인스타그램 클론 코딩 프로젝트입니다.

강의를 기반으로 진행된 프로젝트이며 해당 강의에서는 기본적으로 로그인, 회원정보 수정, 이미지 업로드 등 해당 웹사이트의 핵심적이고 기본적인 기능까지 따라하면서 구현할 수 있도록 제공되었습니다. 이후의 세부적인 기능들은 제 나름대로의 고민과 생각을 통해 추가해본 것들입니다.

프로젝트를 진행하면서 아무래도 처음부터 디자인과 틀이 잡혀있어 더 쉽지 않을까 생각하였지만 오히려 그 틀에 맞추어 코딩을 해야한다는 것이 족쇄처럼 느껴져 어려움을 겪는 경우도 많이 있었습니다. 하지만 이 또한 앞으로 실무를 접함에 있어서 극복해야 할 하나의 과제라고 생각하였기 때문에 이 프로젝트에서 나름의 경험을 쌓고 간다고 생각하였습니다.

막상 구현을 끝내놓고 보니 이전 프로젝트에 비해 담은 것이 별로 없다고 느껴지긴 했지만 해당 프로젝트 나름대로의 새로운 기능들을 접해보고 활용해볼 수 있었다고 생각합니다.

여기까지 긴 글 읽어주셔서 감사합니다.
