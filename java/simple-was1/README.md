# WAS구현 Spec

1. HTTP/1.1 의 Host 헤더를 해석하세요.
- (O), 구현했습니다.
2. 다음 사항을 설정 파일로 관리하세요
- (O), 구현했습니다.
3. 403, 404, 500 오류를 처리합니다
- (O), 구현했습니다.
4. 다음과 같은 보안 규칙을 둡니다.
- (X), 상위 디렉토리 접근에 대한 보안규칙은 적용하지 못 했습니다.
5. logback 프레임워크 http://logback.qos.ch/를 이용하여 다음의 로깅 작업을 합니다.
- (O), 구현했습니다.
6. 간단한 WAS 를 구현합니다.
- (X), 구현하지 못 했습니다.
7. 현재 시각을 출력하는 SimpleServlet 구현체를 작성하세요.
- (O), 구현했습니다.
8. 앞에서 구현한 여러 스펙을 검증하는 테스트 케이스를 JUnit4 를 이용해서 작성하세요.
- (X), 스펙 검증하는 테스트를 작성하지 못 했습니다.
