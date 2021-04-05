drop table if exists product;

CREATE TABLE product (
code int not null,
name varchar(100) not null,
price int,
  PRIMARY KEY (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into product values(111,'삼성TV','3500000');
insert into product values(2222,'애플TV','4500000');
insert into product values(3333,'LGTV','3500000');
insert into product values(4444,'도시바TV','2520000');
insert into product values(5555,'삼성노트북','1200000');
insert into product values(6666,'애플노트북','1200000');
insert into product values(7777,'lg노트북','1200000');

select code, name, price *0.85 from product;

update product set price = 0.8*price where code < 5000;

/* 실수한 점 pk 사용안하고 upddate하려고 했다. 이럴거였으면 그냥 애체오 code 말고 name을 pk로 지정했어야했는 데 겹칠 수가 있으므로 pk를 {code, name}으로 지정했어야했나?*/

select sum(price) "상품들의 총 합계" from product;
