-- boards_category --
INSERT INTO category VALUES (1, 'free');

-- user_info --
INSERT INTO user_info (id, pwd, email, nickname, name) VALUES ('freewifi', 'freewifi', 'freewifi@naver.com', '와이파이빌런', '박전파');
INSERT INTO user_info (id, pwd, email, nickname, name) VALUES ('studyman', 'studyman', 'studyman@gmail.com', '스터디맨', '김공부');
insert into user_info      (id, pwd, email, nickname, name) values('sehwa','1235','sehwa.kim@fast.camp', '캣독', '김세화');
INSERT INTO user_info (id, pwd, email, nickname, name) VALUES ('noriming2', 'choi1234', 'noriming2@gmail.com', 'zero', '최연정');

-- board --
INSERT INTO board (title, content, user_id, category_no )	VALUES ('스프링 스터디 모집합니다.', '스프링 스터디 모집합니다.\r\n장소 : 강남역 부근\r\n회비 : 5만원\r\n교재 : 토비의 스프링\r\n일시 : 매주 토요일 13시 ~ 18시', 'studyman', 1);
INSERT INTO board (title, content, user_id, category_no )	VALUES ('스터디 장소는 어디가 좋을까요?', '스터디를 시작하려 하는데 강남역 부근에 괜찮은 장소 추천좀 해주세요.\r\n가격도 저렴했으면 좋겠습니다.', 'studyman', 1);
INSERT INTO board (title, content, user_id, category_no )	VALUES ('자바 스터디 모집하시는 분?', '자바를 배워보고 싶은데 자바 스터디글을 찾기 힘드네요.\r\n혹시 자바 스터디원 구하시는분 계신가요?\r\n자바 스터디원 구하신다면 hello@gmail.com으로 연락부탁드립니다.', 'studyman', 1);
INSERT INTO board (title, content, user_id, category_no )	VALUES ('보람찬 하루였다.', '아무것도 하지 않은 하루였지만 그래서 더욱 보람찼다.\r\n내일은 더 아무것도 하지 않아서 더 보람차게 보내야 겠다.', 'studyman', 1);
INSERT INTO board (title, content, user_id, category_no )	VALUES ('영어 스터디 찾아요.', '영어 스터디 구합니다.\r\n토익, 원서읽기, 회화 등등 종목 안가립니다.\r\n영어 스터디면 됩니다.\r\nenglishman@gmail.com으로 연락 부탁드립니다.', 'studyman', 1);
INSERT INTO board (title, content, user_id, category_no )	VALUES ('스터디 하기 힘들다..', '공부하기가 싫어서 스터디하기가 싫다.\r\n언제쯤 스터디 인생을 벗어나려나..', 'studyman', 1);
INSERT INTO board (title, content, user_id, category_no )	VALUES ('날씨가 많이 춥네요.', '요즘 날씨가 부쩍 추워졌네요.\r\n옷 얇게 입고 나왔다가 얼어 죽는줄 알았습니다.\r\n다른 지역도 많이 춥나요?', 'studyman', 1);
INSERT INTO board (title, content, user_id, category_no )	VALUES ('오늘 미세먼지 엄청 나다', '아... 미세먼지 개쩐다.\r\n미세먼지 때문에 오늘은 스터디 재껴야지~\r\n날씨 좋아지면 다시 시작이다!!', 'studyman', 1);
INSERT INTO board (title, content, user_id, category_no )	VALUES ('새로나온 아이패드 좋나요?', '아이패드 새로 나온다는데 좋을까요?\r\n애플팬슬도 지원한다는데 살까말까 고민이네요.\r\n혹시 관련 정보 아시는분 계신가요?', 'studyman', 1);
INSERT INTO board (title, content, user_id, category_no )	VALUES ('컴퓨터 잘 아시는분??', '컴퓨터 잘 아시는분 계신가요?\r\n저도 잘 알거든요.\r\n나보다 많이 아는사람 있음 나와보라 그래', 'studyman', 1);
INSERT INTO board (title, content, user_id, category_no )	VALUES ('제주도 사시는분 계신가요?', '다음달에 제주도로 여행가려고 하는데요..\r\n하루만 재워주실분~ 은 뻥이고 숙소는 어디로 잡는게 좋을까요?\r\n되도록 중국인들 적은곳으로 추천해주세요.', 'studyman', 1);
INSERT INTO board (title, content, user_id, category_no )	VALUES ('책 삽니다', '중고책 전문으로 매매합니다.\r\n안보시는 책 있으시면 010-1122-3344로 연락주세요.\r\n책 상태에 따라서 다른곳보다 후하게 쳐드립니다.', 'studyman', 1);
INSERT INTO board (title, content, user_id, category_no )	VALUES ('강남역 근처 맛집 추천좀요', '이번주말에 강남에서 친구 만나기로 했는데, 맛집좀 추천해주세요.\r\n육해공 안가리고 잘먹습니다.\r\n가격은 너무 부담스럽지 않았으면 좋겠습니다.', 'studyman', 1);
INSERT INTO board (title, content, user_id, category_no )	VALUES ('오늘은 강남에 사람이 많네요.', '오늘따라 강남에 사람이 왜 이렇게 많죠?\r\n강남에 무슨 행사 있나요?\r\n팬싸인회 같은거면 저도 알려주세요.', 'studyman', 1);
INSERT INTO board (title, content, user_id, category_no )	VALUES ('강남 교보문고가면 책 많은가요?', '책을 직접보고 구매하고 싶은데 집근처 서점은 책이 별로 없어서요.\r\n혹시 ', 'studyman', 1);
INSERT INTO board (title, content, user_id, category_no )	VALUES ('아....', '심심하다...', 'studyman', 1);
INSERT INTO board (title, content, user_id, category_no )	VALUES ('심심하다', '나만 심심한가???', 'studyman', 1);
INSERT INTO board (title, content, user_id, category_no )	VALUES ('컴퓨터 사양 추천해 주세요.', '인터넷 서핑 잘되고 동영상 잘 돌아가면 됩니다.\r\n30만원이면 살 수 있을까요??\r\n아니면 중고를 알아봐야 할까요?', 'studyman', 1);
INSERT INTO board (title, content, user_id, category_no )	VALUES ('티스토리 블로그 초대장 주실분', '티스토리 블로그 초대장 주실분 계신가요?\r\n이번기회에 블로그를 시작하려고 하는데, 티스토리가 좋다고 추천을 받았습니다.\r\n혹시 초대장 주실 수 있는분 안계실까요?\r\nstory@naver.com으로 초대장 하나 부탁드립니다.', 'studyman', 1);
INSERT INTO board (title, content, user_id, category_no )	VALUES ('배고프다', '밥먹은지 얼마 안되었는데 벌써 배고프네요.\r\n공부를 너무 열심히 해서 그런가?\r\n집중력을 해치지 않기 위해서 어서 간식먹어야 겠네요.', 'studyman', 1);
insert into      board (title, content, user_id, category_no) values ('안녕하세요 가입했어요 ㅋ', '이 많은 내용을 뭘로 채운담ㅎㅎㅎㅎㅎㅎ', 'sehwa', 1);
insert into      board (title, content, user_id, category_no) values ('앱 개발자, 웹 개발자', '혹시 개발자 하시는 분들은 앱개발자를 할지 웹개발자를 할지 어떻게 결정 하셨나요? 그리고 이중 하나만 선택해서 계속 파야하는건가요..?', 'sehwa', 1);
insert into      board (title, content, user_id, category_no) values ('신입연봉은 어느정도 생각하고 있으면 될까요..', '부산에서 취업해야 할것같은데 서울보다는 적을테고 2200~2400정도 생각하면 될까요.. 1800주는데도 보이긴 하던데 ㅠㅠ', 'sehwa', 1);
insert into      board (title, content, user_id, category_no) values ('OSGI관련 질문입니다.', '어쩌다가 OSGI라는 기술을 알게되어 호기심갖고 공부하게됫는데...

제가 이걸 공부하면서 자료도 많이없고 쓰는 이유를 곰곰히생각해봣는데 이게 많이 효율적으로 쓰는가? 에대해서 의문을 갖게되었습니다.

제가아는 OSGI는 특정 기능들을 각각 프로그램처럼 껏다킬수 잇게끔 할수있다. 라는 장점.
즉
서버에 한번에 올리지않고 원하는곳을 슥슥 수정가능하다?? 뭐이런건데..

장점이란게 실제적으로 적용되는사례가잇을까요?', 'sehwa', 1);
insert into board (title, content, user_id, category_no) values ('27살 고민좀 들어주세요~~', '안녕하세요 27살 전문대 컴공 나왔고 정보처리산기 시스템op 1년 다니고 퇴사 했습니다.. 웹개발쪽으로 취업하려하는데요.. 그냥 취업하는게 맞을지.. 좋은 기업 취업을 위해 편입을 해서 대학을 다시 가야할지 고민이네여.. 조언좀 부탁드릴게요 ㅠㅠ', 'sehwa', 1);
insert into board (title, content, user_id, category_no) values ('파이썬으로 b2b 판매용 솔루션 만드시는분~', '안녕하세요~

java로만 쭉 개발하다가 이제 막 파이썬 해보려고하는 개발자인데요

현제 제가 회사에서 만드는 솔루션은 금융/공공 등에 납품되어서 jre7 버젼으로 개발이 허용되고있습니다.

금융과 공공등에서 7버젼정도까지만 설치가 되어 있기때문인데요~

개인프로젝트는 jdk 10 써서 개발해보고있지만요 ㅎㅎ

파이썬도 b2b 판매용버젼에서 지금 허용되는 선이있는건지
있으면 몇 버전인지 궁금하네요~

알고계신분 공유부탁드려요.

사적으로 공부하다가 공부하는시간을 공적인 시간을 만들어 보려고 하고있어요 ㅎㅎ
', 'sehwa', 1);
insert into board (title, content, user_id, category_no) values ('금융 SI 사업부 취업 - 조언 부탁드립니다.', '말그대로 위에 취업했는데요.



경력직 9년차인데 IT경력이 아닌 금융쪽경력입니다. 프로그램 쪽은 지금 공부하고 있습니다.



남궁성 자바의정석 이랑 오라클 SQL 책사서 공부중입니다. 입사전까지 일주일 남았습니다.



혹시 자바 + 오라클 말고 앞으로 어떻게 공부를 진행해야 될지 스케줄 조언좀 부탁드립니다.

', 'sehwa', 1);
insert into board (title, content, user_id, category_no) values ('안녕하세요...24살신입 고민좀 들어주실수있어요??', '저는 전문대나와 현재 24살 중견쯤되는 규모에 전산실에 입사했습니다... 전에도 많이 글을올렸었는데 아직 가닥을 잘 못잡아서 현직자 여러분들에게 물어볼려고합니다. 제가 현재 전산실에서 파워빌더와 오라클을 하고있습니다 아직까지 일을 안시키고 그냥 계속 공부만 하고있어서 파워빌더가 수요가 적고 나중에 이직을 할경우 경력으로 갈수있을지도 의문이고 회사에서 공부 할 시간이 많아서  자바를 공부하고있습니다.(남궁성님의 블로그강의) 자바를 공부하면서 느낀건데 자바는 웹개발or 안드로이드로 가기위해서 쓰는거 같은데 제가 하고싶은거는 응용프로그래머 C/S라고 부르는거 같아요 그런걸 개발하고 싶습니다...C#같이 윈도우폼에다가 컨트롤을 올리는거요. 그래서 1년만 채우고 국비지원을 받아 학원들다닐가...(혼자 하는거는 벅차기도해서요) 아님 2년채우고 기사응시자격증을 되서 기사를 따고 생각을 해볼까요... 지금 정보처리산업기사는 보유중입니다 제가 어떤식으로 공부를 더 해야될까요??? 말이 너무 두서없었네요 ㅠㅠㅠ 사회초년생에 고민을 들어주셔서 감사합니다 답변 기다리겠습니다...



이직하고 싶은이유는 8 To 6 연봉2400 식비 구내식당 퇴직금 미포함입니다 칼퇴 주말공휴일 출근X 그런데 연봉인상률이 매년10만원씩 너무적게 오르는거같고 연차가 공휴일 포함이라 1년에 3~4개밖에없습니다... 근무시간도10시간인데 2400이면 주5일 많이받는 편은 아닌거같구요 저희 부장님이 45살 월390받는거 같아요 (지방입니다) 과장님은 39살인데(290)...

제가 공부를 어떤걸 해야될까요...경력직으로는 아무래도 이직이 힘들겠죠...? 신입으로 지원해야되겠죠..?

', 'sehwa', 1);
insert into board (title, content, user_id, category_no) values ('이제 곧 3년차 되는데', 'it업체가 아니다 보니까 현재 연봉이 2800인데 적당한건지 ㅠ ㅠ

직급이 없어서 100이상 안오를거같은데

이직하게되면 3년차는 어느정도 연봉을 불러야 맞을까요 ?

안드로이드클라이언트 개발하고 있습니다 ㅜ', 'sehwa', 1);
insert into board (title, content, user_id, category_no) values ('취업준비생입니다.', '안녕하세요 22살 6개월 국비지원 끝내고 5개월정도 취업준비하고있습니다.
제가 일단 군대를 안갔다와서 it병특업체로 병특받으면서 일을하려구하는데요 특성화고졸업자에 정보처리기능사 자격증 있습니다.
그런데 보충역쪽에선 많이전화가 오더군요 그런데 현역은 자리가 없다고 하시더라구요.. 그래서
그냥 일반 SI업체나 웹개발직을 지원해서 들어가서 병역신청을 해달라할까 생각중입니다..

참고민이 많은데요 프로젝트 제 맡은업무는 게시판,로그인,결제시스템,네이버 스마트에디터,주소API등 활용을했구요,
BootStrap을이용해서 관리자단 페이지를 만들었고 model1방식도사용했고 model2(mvc)방식으로바꿨구요 Oracle은 jdbc를사용하다 커넥션풀을이용한jndi를 사용했습니다. 프론트단은 Spring Frame /Mybatis/maven을이용해서 구현을 했습니다.

근데 회사에선 확실히 제가 고졸이고 미필이여서 제가이력서를 넣어도 연락이 별로없더라구요..

근데 it라는곳은 안하면 안할수록 까먹기떄문에 저혼자 프로젝트를 만들어서 간단한 게시판,로그인 등 기초를 튼튼하게 다지면서
회사 기다리는게 나을까요? 요즘 정말 무기력해지고 손에안잡히네요..
', 'sehwa', 1);
insert into board (title, content, user_id, category_no) values ('자바 필기테스트	', '담주가 비트교육센터 기업맞춤교육

6개월 과정 선발을 위한

필기테스트를 보는데

시험이 어떤식으로 나올지 몰라서 긴장되네요~

대기업처럼 순수 알고리즘 손코딩만 나올지

자잘한 개념(연산자, 개념 묻기 등)들로 나올지 ~

비트교육의 자바 필기테스트의 문제가 어떻게 나올지몰라서 지금 자바기본서를 다시보는데

기업 2차 최종면접보다 비트 필기테스트가 더 긴장되는건 첨이네요~

혹시 비트 기업 필시시험 보신분 계시면 어떻게 나오는지 알고싶습니다.~', 'sehwa', 1);
insert into board (title, content, user_id, category_no) values ('정보처리기사 실기', '얼마안남은 실기 열공중입니다.

궁금한게

실기도 필기때처럼

시험지를 갖고나올수 있는지

당일날 저녁에 홈페이지에 가답안이 올라와서
갖고온 시험지를 가채점할수 있는지 알고싶습니다.', 'sehwa', 1);
insert into board (title, content, user_id, category_no) values ('대학생인데 개발자로취업관련 포트폴리오대해서 질문점할게요', '현재 1학년인데 군대는 다녀왔고 전문대라 3년제입니다.
3학년졸업작품 및 취업용프토폴리오용으로 안드로이드 어플을 개발하고싶은데
java와 android 의외에 어플개발에 필요한 데이터베이스나 서버?를 연동하려면 어떤거를 공부해야되고
안드로이드앱개발이 개발자로 취업하는데에있어서 어느정도 효력?이 있는지 궁금합니다.
', 'sehwa', 1);
insert into board (title, content, user_id, category_no) values ('코딩할때 마음이 조급한거같아요', '코드작성할때 마음이 급하거나 들뜨네요
결과를 빨리 만들어 낼려는 생각이 있나?
차분히 코딩했으면 좋겠는데
조급한거같네요', 'sehwa', 1);
insert into board (title, content, user_id, category_no) values ('대학생인데 개발자로취업관련 포트폴리오대해서 질문점할게요', '현재 1학년인데 군대는 다녀왔고 전문대라 3년제입니다.
3학년졸업작품 및 취업용프토폴리오용으로 안드로이드 어플을 개발하고싶은데
java와 android 의외에 어플개발에 필요한 데이터베이스나 서버?를 연동하려면 어떤거를 공부해야되고
안드로이드앱개발이 개발자로 취업하는데에있어서 어느정도 효력?이 있는지 궁금합니다.', 'sehwa', 1);
insert into board (title, content, user_id, category_no) values ('
뉴비의 일본it회사 출근 후기 및 질문', '안녕하세요 일본에서 무역을 전공하다가 이번에 it쪽으로 전직을 성공하게 된 뉴비입니다.

적지 않은 나이에 전직을 성공하게 되어서 후기 및 질문 작성해봅니다.

자바를 이용한 웹 개발을 기본 베이스로 자바, jsp서블릿, 스프링, 아주 기초적인 sql 정도 공부 하고

취업을 하게 되었습니다. 공부는 전부다 직접 독학으로 책과 동영상 강의 그리고 실습으로 연습했습니다.

기본적으로 파견회사인데 운이 좋게 아주 큰 규모의 좋은 회사로 들어가게 되었습니다. 기본은 스프링 기반

사내 시스템 개발 및 운영 보수로 이야기를 하고 면접을 보고 출근하게 되었습니다.

나중에 물어보니 정말 it지식이 부족해서 그부분을 솔직하게 면담때 다 말했는데 배울려는 자세가 있고

일본어를 할줄알아서 뽑았다고 하더군요 일은 배우면서 하면 된다고 정말 좋은 분위기에 살짝 감동도 했습니다.

두근 거리는 마음으로 열심히 공부를 계속 하면서 첫출근을 기다렸는데 하루전에 업무 내용이 약간 바뀌었다고

하더군요 ㅜㅜ 혹시나 하고 출근해서 보니 스프링 기반 개발은 일단 멈추고 프로젝트 관리 프로그램 trac의 데이터

를 레드마인으로 옮기는 작업을 하라는겁니다. ㅜㅜ

레드마인은 일단 써본적도 없고 trac도 잘 모르고 db쪽도 많이 부족한데 앞으로 어떻게 해나가야할지 걱정입니다.

일단 마이그레이션을 해본적도 없고 또 데이터를 이동시킬때 발생할 수 있는 오류들을 수정하는 간단한 툴까지

만들어야 하는 상황입니다. ㅜㅜ 어디를 어떻게 변경하게 할지도 감이 안오고 머리속이 하얗게 변해 로직도 상상도

안되고 ㅜㅜ  멘붕이 바로 와버렸습니다. 회사는 정말 분위기 좋고 정말 좋은곳인데 왜 이런 시련이 첫날부터

온지... 마이그레이션을 했을때 티켓의 내용과 이슈(일감)의 내용이 틀려지거나 시간 이나 날짜 데이터가 꼬이고

이상해 져버릴텐데 어느부분을 어떻게 수정하는 툴을 제작해야할지도 정말 모르겠습니다. ㅜㅜ

이부분이 가장 큰 문제였고 버젼관리를 svn을 gitlab으로 바꾸는 문제나 테스트툴 젠킨스 사용이나 커뮤니티툴

mattermost 연동등의 문제도 있군요 (그래도 이부분은 어떻게 될거 같은데...어휴 가장 큰 문제가 걱정입니다. ㅜㅜ)

협업이라곤 해본적도 없고 항상 혼자 공부해왔는데 팀개발에 관한 환경을 만드는것도 아니고 변경을 하라니...하아



뉴비의 일본 it 회사 출근 첫날부터 맨붕입니다. ㅜㅜ 검색해보니까 관련 내용도 없던데 흑흑

이상 뉴비의 1일차 일본it회사 출근 후기 및 질문이였습니다.

', 'sehwa', 1);
insert into board (title, content, user_id, category_no) values ('철야 힘드네요.', '철야 작업 중인데..

정말 힘드네요..

잠이와서..ㅠㅠ

여러분들 잠 극복 어떻게 하나요?

커피를 못마시니..', 'sehwa', 1);
insert into board (title, content, user_id, category_no) values ('
신입 개발자입니다.', '저는 이제 4개월된 신입 개발자입니다.

대학교 졸업할때까지 개발자라는 직업을 선택하지 않았지만

한번 해보자는 마음에 독학으로 프로젝트 만들고 열심히 6개월동안 준비해서 입사를 했습니다.

제가 특정 언어나 플랫폼을 파고든것이 아니라 자바 -> 안드로이드 -> php 이런순서로 공부 했습니다.

물론 대학교 때 지식이 있어서 문법위주가 아닌 그냥 맨땅에 해딩하는 식으로 공부했습니다.

처음 일기장 어플을 만들어보고 php를 이용해서 게시판을 만들고 안드로이드, php를 연동해서

커플어플(공유)를 만들기도 했습니다. 채팅기능(소켓통신)을 하려다가 회사에 입사를했습니다.



 책으로 공부한것이 아니라 이건 어떻게하지??그냥 구글검색하고 소스붙여넣고 돌려보고...그런식으로 공부했습니다.

지금 회사는 php웹개발쪽으로 왔는데 앞으로 어떻게 공부하고 경력을 쌓아야 할지 고민입니다.

외주를 받는 것도아니고 자체개발이라 요즘은 크게할일이 많은것도 아닙니다...

처음에는 신입이지만 경력자만큼은 아니지만 실력있는 개발자가 꿈이였는데

지금은 회사 여러가지 업무를하고 개발업무를 많이 하고있지는 않네요ㅋㅋㅋ

여러 선배님들이 계신데 위의 제가했던 공부방식이 잘된건지 앞으로 어떻게 해나가는게 좋을지

조언 부탁드립니다~^^', 'sehwa', 1);
insert into board (title, content, user_id, category_no) values ('if/else 문을 직접 만들 수 있을까요?', '안녕하세요.

지나가는 웹 개발자입니다.
최근 공부를 하다가 if/else문이 어떻게 동작하는지 궁금해서 코드를 짜보려고 노력을 했습니다..
알고리즘 공부가 부족했는지..잘안되네요..ㅠㅠ if/else문 에서 다중 if/else와 변수/함수처리 부분을 만들어보려고 하는데
ex)
String a = "apple";
String b = "banana";
String result = "";
if(a.equal("apple"))
  if(b.equal("banana"))
      result = "Y";
  else
      result = "N";
else
  result = "N"

만들어 보시거나 혹시 생각 해보신 분들 중에서 팁이나 생각을 공유 했스면 좋겠습니다.
제가 알고리즘 이런쪽에서는 조금 부족해서요 도움부탁드립니다 ㅎ..

추가 설명)))
내용을 좀더 구체적으로 넣어볼게요..
if/else문과 비슷한 스트링 값을 받아서 다중 if/else문을 처리하는 것입니다.
ex) String a = "if([a]==[c] ||[a]==[b]){[a]=[banana]}";
대괄호를 문자로 처리합니다. 나머지 기호는 자바랑 같습니다.

이런식의 String 값을 받아서 다중 if/else문을 처리해보려고 하는 것 입니다.', 'sehwa', 1);
insert into board (title, content, user_id, category_no) values ('gitbash에서 디렉토리 트리구조로 보려면', '리눅스에서 특정 디렉토리 트리형태로 보려면 tree -d /해당 디렉토리 이렇게 하면 됐던거 같은데
git bash에서는 tree 명령어가 안되는데

혹시 git bash에서 디렉토리 트리구조로 보는 명령어 아시는분 답변 부탁드립니다..
', 'sehwa', 1);
INSERT INTO board (title, content, user_id, category_no ) VALUES ('웹발사 2차 스프링 스터디 모집','현재  저와  김승곤님 2명이  진행하기로  하였고, 추가로 4명을  모집하고자  공고합니다.스터디  진행은  이틀간 7시간씩  진행되며, 스터디원 6명이  각자  담당하는  챕터에  대해  발표자료를  준비해와야합니다.발표  챕터는 17년 4월 23일  오티를  진행하면서  제비뽑기로  정하겠습니다..훗','noriming2',1);
INSERT INTO board (title, content, user_id, category_no )  VALUES ('JavaScript스터디 모집 기초부터','교재는 스터디원간 협의하여 교재를 정하고 해당교재의내용을 공부하고 예제를 같이 코딩하는 방식으로 진행하고 추후 작은 프로젝트부터 점진적으로 프로젝트를 진행하는 형식을 취하려고생각중입니다.','noriming2',1);
INSERT INTO board (title, content, user_id, category_no ) VALUES ('javascript로 풀스택을~!','서버단 node.js 부터  프론트단 react.js 까지, 프로젝트를  목표로  하는  스터디  그룹에서  스터디원  추가  모집합니다..','noriming2',1);
INSERT INTO board (title, content, user_id, category_no ) VALUES ('안드로이드 스터디 모집합니다','안드로이드를 배우고 싶고, 꾸준한 자기 계발을 하고자 하시는 분들과 함께 하고 싶습니다. 목표 : 안드로이드 프레임워크를 이해하고, 원하는데로 앱을 제작 가능한 레벨','noriming2',1);
INSERT INTO board (title, content, user_id, category_no ) VALUES ('성남쪽에서 웹스터디 같이하실분 찾습니다','위의 책으로 목표한 공부 해오고 모임날 서로 모르는거 알려주면서 진행할 계획입니다. 위의 책으로 기초를 다지면 심화과정책으로 공부할 예정입니다','noriming2',1);
INSERT INTO board (title, content, user_id, category_no ) VALUES ('빅데이터 입문자스터디','교재는 스터디원간 협의하여 교재를 정하고 해당교재의내용을 공부하고 예제를 같이 코딩하는 방식으로 진행하고 추후 작은 프로젝트부터 점진적으로 프로젝트를 진행하는 형식을 취하려고생각중입니다.','noriming2',1);
INSERT INTO board (title, content, user_id, category_no ) VALUES ('자바의 정석 10독 스터디 인원 모집합니다','매일매일 쉼없이 읽으실수 있으신분~! 자바를 다시 봐야겠다 하시는분~!매일은 아니지만 꾸준히 읽겠다 하시는분~!대신 읽으실때마다 인증샷을 남겨 주셨으면 합니다 책과 함께 ㅎㅎ','noriming2',1);
INSERT INTO board (title, content, user_id, category_no ) VALUES ('삼성증권 사태로 당분간 증권사 플젝은 힘들어질까요?','증권사 관련 시스템 구축이 아주 빡새질꺼 같은데..증권사 SM하시는 분들도 지금은 비상근무 하고 난리도 아니겠죠?','noriming2',1);
INSERT INTO board (title, content, user_id, category_no ) VALUES ('다... 부질없는 짓','최신기술...아님.. 그냥 기술...다.... 부질없는 짓 한국에서 잘 살고 싶음...금융업무 하나 꽉 잡고 있는게열 기술 안부럽게 ... 오래오래 행복하게 잘사는 길 입니다.','noriming2',1);
INSERT INTO board (title, content, user_id, category_no ) VALUES ('국비 상담받고 왔어요','2시간 동안이나 상담받았습니다 먼저 오랜시간동안 상담해주셔서 감사하네요 그런데 제가 목표는 ai라고 말씀드리면서 상담을 시작하니 결론은 c언어를 배우라고 하시는데 제 생각은 개발자로 언어 하나만 배울게 아니기 때문에 국비로 자바를 먼저 배우고 취업해서 경력쌓으면서 c를 배우는게 더 낳지 않을까 생각하는데 (신입이라 공부환경이 열악하겠지만 추후에라도) 물론 상담해주신분의 의도는 기본을 튼튼하게 시작하라고 해주시는 말 같은데 고민이됩니다
도와주세요 선배님들','noriming2',1);
INSERT INTO board (title, content, user_id, category_no ) VALUES ('안드로이드 버전 만드는 사람들 뭔가 부럽당..','나도 해보고싶다..이번에 이 버전으로 올리면서 이거 못쓰게해야지 엌ㅋㅋㅋ개발자들 울상짓는거 개꿀잼ㅋㅋㅋㅋ제일 많이쓰는거 하나 골라서 그 다음버전에서 못쓰게하잨ㅋ?','noriming2',1);
INSERT INTO board (title, content, user_id, category_no ) VALUES ('신입 포트폴리오 구성 및 내용 고민입니다ㅠㅠ','구글링을 해보아도 감이 잡히지 않아서요ㅠㅠ
비전공자로 도전하여 이제 국비지원학원 수료를 눈앞에 두고있습니다 포트폴리오밖에 보여줄 것이 없는데 어떻게 구성해야할 지 잘 모르겠어요 우선 ppt로 만들었구요 맨앞에 프로젝트 개발환경 등 표로 설명했고 그다음이 문제인데 화면-코드-설명 이렇게 구성했는데 구글링 해보면 화면-설명 or 화면만 보여주는 것도 많더라구요 코드나 설명을 굳이 포함시키지 않아도 되는것인가요? 포함시킨다면 각각 비중을 어느정도로 해야할까요??','noriming2',1);
INSERT INTO board (title, content, user_id, category_no ) VALUES ('와..답답해죽겠음..','JSP는 JAVA파일을 보지않는 이상 작업하기 힘들다 라고 답해줬는데 FTP말하면서 PHP는 FTP보면 다보는데 JAVA는 왜 못보냐 너가 실력이없는거아니냐 JAVA파일이 없는데 왜 사이트는 구동되고 있느냐 이런식으로나오네요... class랑 컴파일에대해 그렇게 설명했는데 이해못하시는데 진짜 퇴사하고싶당..','noriming2',1);
INSERT INTO board (title, content, user_id, category_no ) VALUES ('페미니즘 뜻','페미니즘을 네이버 어학사전에 검색해보면 "성별로 인해 발생하는 정치ㆍ경제 ㆍ사회 문화적 차별을 없애야 한 다는 견해."라고 나옵니다. 저도 이렇게 알고 있었고 페미니즘은 당연한거지만 한국에서는 변질되었다고 생각했죠.그러나 지식백과 두산백과에 검색된 내용은 "여성의 권리 및 기회의 평등을 핵심으로 하는 여러 형태의 사회적∙정치적 운동과 이론들을 아우르는 용어."라고 나오네요. 어떤게 정확히 맞는지 아시는분 있나요? 전자의 경우는 양성평등을 주장하지만 후자의 경우에는 양성평등보다는 여자만을 위한 사상에 가깝네요','noriming2',1);
INSERT INTO board (title, content, user_id, category_no ) VALUES ('면접 대답을 어떻게 해야할지 모르겠어요','제일 힘든 질문이 저의 장단점을 물어보는 것인데
이 질문의 의도를 아직도 잘 모르겠어요..업무에 관해서의 장단점을 묻는 것인지, 인격에 관해서 장단점을 묻는 것인지..그리고 제가 사용하지 못해본 언어, 기술에 대해서 사용해본적이 있느냐,할줄 모르는 것은 배워서 사용해야할 것인데 어떻게 할것이냐 보통 이런 질문도 있었습니다.선배님들의 조언을 듣고싶습니다','noriming2',1);
INSERT INTO board (title, content, user_id, category_no ) VALUES ('구글 코드잼은 어느정도 수준이어야 푸는건가요?','대체 구글에서 원하는 사람은 어떤 알고리즘을 구현할 수 있는걸까..','noriming2',1);
INSERT INTO board (title, content, user_id, category_no ) VALUES ('JAVA를 독학하기 위한 커리큘럼 조언 구합니다','일단 아무래도 국내 표준과 같은 JAVA, SPRING을 배우고 프로젝트를 진행하며 포폴을 만들려고 합니다.혹시 JAVA를 셀프스터디 하기 위한 커리큘럼이나 코스 혹은 어떤 거를 배워야 한다던지 하는 것이 있을까요?','noriming2',1);
INSERT INTO board (title, content, user_id, category_no ) VALUES ('여기가 티스토리 초대장 주는 곳인가요?','언젠가부터 개발자 커뮤니티의 본질보다는 신규 가입자들이 티스토리 블로그 초대장 받으러 오는 곳이 된거 같습니다.제재가 필요할 것 같습니다.','noriming2',1);
INSERT INTO board (title, content, user_id, category_no ) VALUES ('어려운 산수/수학의 중요성','산수, 수학에 약해서.. 큰일 이네요...다시.. 수학 공부에 매진해야 겠어요 ...수학과의 ... 전쟁 ㅎ','noriming2',1);
INSERT INTO board (title, content, user_id, category_no ) VALUES ('최종면접때 가서 확인해야할게 뭐가 있을까요?','근로계약서는 부당한 일을 당할경우 최후의 보루라고 많이 들었는데 그러면서도 막상 뭘 확인해야 하는지는 잘 모르겠네요.선배님들 조언 부탁드립니다ㅠ','noriming2',1);



-- comment --
INSERT INTO COMMENT	(board_no, content, user_id, depth, comment_group)	VALUES (1, '글이 왜 이러냐??', 'freewifi', '1', 0);
INSERT INTO COMMENT	(board_no, content, user_id, depth, comment_group)	VALUES (1, '글 진짜 이상하다..', 'freewifi', '1', 0);
INSERT INTO COMMENT	(board_no, content, user_id, depth, comment_group)	VALUES (1, '뭐 임마??', 'studyman', '2', 0);
INSERT INTO COMMENT	(board_no, content, user_id, depth, comment_group)	VALUES (1, '글 이상한거 못느낌??', 'freewifi', '2', 0);
INSERT INTO COMMENT	(board_no, content, user_id, depth, comment_group)	VALUES (1, '너는 얼마나 글 잘쓰는데??', 'studyman', '2', 0);
INSERT INTO COMMENT	(board_no, content, user_id, depth, comment_group)	VALUES (1, '내가 글을 잘쓴다는게 아니고, 글이 이상하다고', 'freewifi', '2', 0);
INSERT INTO COMMENT	(board_no, content, user_id, depth, comment_group)	VALUES (1, '너같은 놈이랑 말을 말아야지.', 'studyman', '2', 0);
INSERT INTO COMMENT	(board_no, content, user_id, depth, comment_group)	VALUES (1, '갑자기 왜 시비?? 글이 이상해서 이상하다 그랬는데 뭐가 잘못이냐?', 'freewifi', '2', 0);
INSERT INTO COMMENT	(board_no, content, user_id, depth, comment_group)	VALUES (1, '미안하다. 내가 착각했다. 너같은 놈에게 댓글쓴 내가 잘못이지.', 'studyman', '2', 0);
INSERT INTO COMMENT	(board_no, content, user_id, depth, comment_group)	VALUES (1, '응. 니잘못.', 'freewifi', '2', 0);
INSERT INTO COMMENT	(board_no, content, user_id, depth, comment_group)	VALUES (1, '좋냐??', 'studyman', '2', 0);
INSERT INTO COMMENT	(board_no, content, user_id, depth, comment_group)	VALUES (1, 'ㅇㅇ', 'freewifi', '2', 0);
INSERT INTO COMMENT	(board_no, content, user_id, depth, comment_group)	VALUES (1, '나 이제 간다. 댓글 그만 달아라.', 'freewifi', '2', 0);
INSERT INTO COMMENT	(board_no, content, user_id, depth, comment_group)	VALUES (1, '갔냐??? 안간거 다안다. 얼른 댓글 달아라.', 'studyman', '2', 0);
INSERT INTO COMMENT	(board_no, content, user_id, depth, comment_group)	VALUES (1, '진짜 갔냐??', 'studyman', '2', 0);
INSERT INTO COMMENT	(board_no, content, user_id, depth, comment_group)	VALUES (1, '는 훼이크다. 이제 진짜 가야된다.', 'freewifi', '2', 0);
INSERT INTO COMMENT	(board_no, content, user_id, depth, comment_group)	VALUES (1, '왜 아직 안감?? 미련이 남았나??', 'studyman', '2', 0);
INSERT INTO COMMENT	(board_no, content, user_id, depth, comment_group)	VALUES (1, '......', 'freewifi', '1', 0);
INSERT INTO COMMENT	(board_no, content, user_id, depth, comment_group)	VALUES (1, '..................', 'freewifi', '1', 0);
INSERT INTO COMMENT	(board_no, content, user_id, depth, comment_group)	VALUES (1, '..............................', 'freewifi', '1', 0);
insert into comment		    (board_no, content, user_id, comment_group) values ('1', '와 1빠다', 'sehwa', 0);
insert into comment  	    (board_no, content, user_id, comment_group) values ('1', '와 2빠다', 'sehwa', 0);
insert into comment  	    (board_no, content, user_id, comment_group) values ('1', '와 3빠다', 'sehwa', 0);
insert into comment  	    (board_no, content, user_id, comment_group) values ('1', '와 4빠다', 'sehwa', 0);
insert into comment  	    (board_no, content, user_id, comment_group) values ('1', '와 5빠다', 'sehwa', 0);
insert into comment  	    (board_no, content, user_id, comment_group) values ('1', '와 6빠다', 'sehwa', 0);
insert into comment  	    (board_no, content, user_id, comment_group) values ('1', '와 7빠다', 'sehwa', 0);
insert into comment  	    (board_no, content, user_id, comment_group) values ('1', '와 8빠다', 'sehwa', 0);
insert into comment  	    (board_no, content, user_id, comment_group) values ('1', '와 9빠다', 'sehwa', 0);
insert into comment  	    (board_no, content, user_id, comment_group) values ('1', '와 10빠다', 'sehwa', 0);
insert into comment  	    (board_no, content, user_id, comment_group) values ('1', '와 11빠다', 'sehwa', 0);
insert into comment  	    (board_no, content, user_id, comment_group) values ('1', '와 12빠다', 'sehwa', 0);
insert into comment  	    (board_no, content, user_id, comment_group) values ('1', '와 13빠다', 'sehwa', 0);
insert into comment  	    (board_no, content, user_id, comment_group) values ('1', '와 14빠다', 'sehwa', 0);
insert into comment  	    (board_no, content, user_id, comment_group) values ('1', '와 15빠다', 'sehwa', 0);
insert into comment  	    (board_no, content, user_id, comment_group) values ('1', '와 16빠다', 'sehwa', 0);
insert into comment  	    (board_no, content, user_id, comment_group) values ('1', '와 17빠다', 'sehwa', 0);
insert into comment  	    (board_no, content, user_id, comment_group) values ('1', '와 18빠다', 'sehwa', 0);
insert into comment  	    (board_no, content, user_id, comment_group) values ('1', '와 19빠다', 'sehwa', 0);
insert into comment  	    (board_no, content, user_id, comment_group) values ('1', '와 20빠다', 'sehwa', 0);
INSERT INTO comment    (board_no,content,user_id,depth,comment_group) VALUES (1,'신나는 도배놀이~~~~','noriming2',1,0);
INSERT INTO comment    (board_no,content,user_id,depth,comment_group) VALUES (1,'신나는 도배놀이~~~~','noriming2',1,0);
INSERT INTO comment    (board_no,content,user_id,depth,comment_group) VALUES (1,'신나는 도배놀이~~~~','noriming2',1,0);
INSERT INTO comment    (board_no,content,user_id,depth,comment_group) VALUES (1,'신나는 도배놀이~~~~','noriming2',1,0);
INSERT INTO comment    (board_no,content,user_id,depth,comment_group) VALUES (1,'신나는 도배놀이~~~~','noriming2',1,0);
INSERT INTO comment    (board_no,content,user_id,depth,comment_group) VALUES (1,'신나는 도배놀이~~~~','noriming2',1,0);
INSERT INTO comment    (board_no,content,user_id,depth,comment_group) VALUES (1,'신나는 도배놀이~~~~','noriming2',1,0);
INSERT INTO comment    (board_no,content,user_id,depth,comment_group) VALUES (1,'신나는 도배놀이~~~~','noriming2',1,0);
INSERT INTO comment    (board_no,content,user_id,depth,comment_group) VALUES (1,'신나는 도배놀이~~~~','noriming2',1,0);
INSERT INTO comment    (board_no,content,user_id,depth,comment_group) VALUES (1,'신나는 도배놀이~~~~','noriming2',1,0);
INSERT INTO comment    (board_no,content,user_id,depth,comment_group) VALUES (1,'신나는 도배놀이~~~~','noriming2',1,0);
INSERT INTO comment    (board_no,content,user_id,depth,comment_group) VALUES (1,'신나는 도배놀이~~~~','noriming2',1,0);
INSERT INTO comment    (board_no,content,user_id,depth,comment_group) VALUES (1,'신나는 도배놀이~~~~','noriming2',1,0);
INSERT INTO comment    (board_no,content,user_id,depth,comment_group) VALUES (1,'신나는 도배놀이~~~~','noriming2',1,0);
INSERT INTO comment    (board_no,content,user_id,depth,comment_group) VALUES (1,'신나는 도배놀이~~~~','noriming2',1,0);
INSERT INTO comment    (board_no,content,user_id,depth,comment_group) VALUES (1,'신나는 도배놀이~~~~','noriming2',1,0);
INSERT INTO comment    (board_no,content,user_id,depth,comment_group) VALUES (1,'신나는 도배놀이~~~~','noriming2',1,0);
INSERT INTO comment    (board_no,content,user_id,depth,comment_group) VALUES (1,'신나는 도배놀이~~~~','noriming2',1,0);
INSERT INTO comment    (board_no,content,user_id,depth,comment_group) VALUES (1,'신나는 도배놀이~~~~','noriming2',1,0);
INSERT INTO comment    (board_no,content,user_id,depth,comment_group) VALUES (1,'신나는 도배놀이~~~~','noriming2',1,0);

SET @rank = 0;

UPDATE COMMENT SET comment_group = (@rank:=@rank+1);

UPDATE COMMENT SET comment_group = 2 WHERE depth = 2;