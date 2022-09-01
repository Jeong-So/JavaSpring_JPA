--call next value for hibernate_sequence;
insert into users (`id`,`name`,`email`,`created_at`,`updated_at`,`allow`) values(1, 'jeong','jeong@naver.com', now(), now(), true);

--call next value for hibernate_sequence;
insert into users (`id`,`name`,`email`,`created_at`,`updated_at`,`allow`) values(2, 'dennis','dennis@naver.com', now(), now(), false);

--call next value for hibernate_sequence;
insert into users (`id`,`name`,`email`,`created_at`,`updated_at`,`allow`) values(3, 'sophia','sophia@gmail.com', now(), now(), true);

--call next value for hibernate_sequence;
insert into users (`id`,`name`,`email`,`created_at`,`updated_at`,`allow`) values(4, 'james','james@gmail.com', now(), now(), true);

--call next value for hibernate_sequence;
insert into users (`id`,`name`,`email`,`created_at`,`updated_at`,`allow`) values(5, 'jeong','jeong@gmail.com', now(), now(), false);

--call next value for hibernate_sequence;
insert into users (`id`,`name`,`email`,`created_at`,`updated_at`,`allow`) values(6, 'jeong','jeong@hanmail.com', now(), now(), false);

--전략을 @GeneratedValue(strategy = GenerationType.IDENTITY) 바꾸면
--call next value for hibernate_sequence; 없애야 함 안그럼 hibernate_sequence를 못찾는다는 오류 나옴
