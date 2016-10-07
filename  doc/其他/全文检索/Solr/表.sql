--创建博客表
CREATE TABLE blog(
	id varchar2(11) PRIMARY KEY,			--博客ID
	author varchar2(200) ,					--博客作者
	city varchar2(20),						--作者所在城市
	title varchar2(200),					--博客标题
	content clob NOT NULL,       			--博客内容
	create_date date DEFAULT SYSDATE		--博客创建时间			
);

--创建索引
CREATE SEQUENCE seq_blog
START WITH 1
INCREMENT BY 1;

--插入数据
INSERT INTO blog(id, author, city, title, content, create_date) values(seq_blog.NEXTVAL, '张三', '沈阳', 'Java入门', 'Java是一门面向对象编程语言，不仅吸收了C++语言的各种优点，还摒弃了C++里难以理解的多继承、指针等概念，因此Java语言具有功能强大和简单易用两个特征',to_date('2002-01-01','YYYY-MM-DD'));
INSERT INTO blog(id, author, city, title, content, create_date) values(seq_blog.NEXTVAL, '李四', '北京', 'Oracle入门', '甲骨文公司，全称甲骨文股份有限公司(甲骨文软件系统有限公司)，是全球最大的企业级软件公司，总部位于美国加利福尼亚州的红木滩。1989年正式进入中国市场。2013年，甲骨文已超越 IBM ，成为继 Microsoft 后全球第二大软件公司。',to_date('2008-01-01','YYYY-MM-DD'));
INSERT INTO blog(id, author, city, title, content, create_date) values(seq_blog.NEXTVAL, '王五', '上海', 'Java入门', 'Java是一门面向对象编程语言，不仅吸收了C++语言的各种优点，还摒弃了C++里难以理解的多继承、指针等概念，因此Java语言具有功能强大和简单易用两个特征',to_date('2008-03-05','YYYY-MM-DD'));
INSERT INTO blog(id, author, city, title, content, create_date) values(seq_blog.NEXTVAL, '赵六', '太原', 'PHP入门', 'PHP（外文名:PHP: Hypertext Preprocessor，中文名：“超文本预处理器”）是一种通用开源脚本语言。语法吸收了C语言、Java和Perl的特点，利于学习，使用广泛，主要适用于Web开发领域。',to_date('2005-05-05','YYYY-MM-DD'));
INSERT INTO blog(id, author, city, title, content, create_date) values(seq_blog.NEXTVAL, '小明', '石家庄', 'C++入门', 'C++是在C语言的基础上开发的一种面向对象编程语言，属于编译型语言，应用广泛；C++支持多种编程范式 －－面向对象编程、泛型编程和过程化编程',to_date('2004-06-01','YYYY-MM-DD'));
INSERT INTO blog(id, author, city, title, content, create_date) values(seq_blog.NEXTVAL, '张三丰', '沈阳', 'Python入门', 'Python（英国发音：/ˈpaɪθən/ 美国发音：/ˈpaɪθɑːn/）, 是一种面向对象、解释型计算机程序设计语言，由Guido van Rossum于1989年发明，第一个公开发行版发行于1991年。',to_date('2012-01-01','YYYY-MM-DD'));
INSERT INTO blog(id, author, city, title, content, create_date) values(seq_blog.NEXTVAL, '乔峰', '上海', '.net入门', '.NET是 Microsoft XML Web services 平台。XML Web services 允许应用程序通过 Internet 进行通讯和共享数据，而不管所采用的是哪种操作系统、设备或编程语言。',to_date('2022-12-01','YYYY-MM-DD'));

