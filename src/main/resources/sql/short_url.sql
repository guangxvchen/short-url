
CREATE TABLE
    short_url
    (
        id bigint NOT NULL,
        title VARCHAR(255) COMMENT '标题',
        md5 VARCHAR(255) COMMENT 'md5',
        url_key VARCHAR(255) COMMENT '短连接映射',
        create_time bigint COMMENT '创建时间',
        url_value text COMMENT '源地址',
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_general_ci;

INSERT INTO short_url (id, title, md5, url_key, create_time, url_value) VALUES (1177781343110832129, '来了！新闻早班车', '6ded10585bf033d4328436c8aa6f12a2', '5BF033D4', 1569639928972, 'http://mp.weixin.qq.com/s?__biz=MjM5MjAxNDM4MA==&amp;mid=2666274168&amp;idx=1&amp;sn=8aacbbf59630781ab98f6ba3342af81f&amp;chksm=bdb4743b8ac3fd2d1ef3b819cb26b6125e0802a1ab6067b4ddf836bb910bd24f06c77c2523eb&amp;mpshare=1&amp;scene=1&amp;srcid=0928v0Ps7eHXsW1IDD0ylCDb&amp;sharer_sharetime=1569639671829&amp;sharer_shareid=9495b59240964dd7ba438decbdf4dc56#rd');
INSERT INTO short_url (id, title, md5, url_key, create_time, url_value) VALUES (1177781461222432769, '早啊！新闻来了〔2019.09.28〕', 'e649faf5f4c50a4143669d4136e21b7e', 'F4C50A41', 1569639957133, 'http://mp.weixin.qq.com/s?__biz=MTI0MDU3NDYwMQ==&amp;mid=2656804994&amp;idx=1&amp;sn=4d0e5adc582f13132ed4844e07acf6c7&amp;chksm=7a615d644d16d472ca2b06d8d9cf6aabead59409edd22de8b51cb07344d2a469b32e4e99ccf8&amp;mpshare=1&amp;scene=1&amp;srcid=&amp;sharer_sharetime=1569639951633&amp;sharer_shareid=9495b59240964dd7ba438decbdf4dc56#rd');
INSERT INTO short_url (id, title, md5, url_key, create_time, url_value) VALUES (1177947202429132801, '来了！新闻早班车', 'c578400f6e4d97e6cf294d5176e15b29', '6E4D97E6', 1569679472915, 'http://mp.weixin.qq.com/s?__biz=MjM5MjAxNDM4MA==&amp;mid=2666274168&amp;idx=1&amp;sn=8aacbbf59630781ab98f6ba3342af81f&amp;chksm=bdb4743b8ac3fd2d1ef3b819cb26b6125e0802a1ab6067b4ddf836bb910bd24f06c77c2523eb&amp;mpshare=1&amp;scene=1&amp;srcid=&amp;sharer_sharetime=1569679469679&amp;sharer_shareid=cb69e8279d712b7b4136badae8a293b0#rd');
INSERT INTO short_url (id, title, md5, url_key, create_time, url_value) VALUES (1177947324701483010, '来了！新闻早班车', 'ac899c9064ff1fbb7d917909dba46406', '64FF1FBB', 1569679502068, 'http://mp.weixin.qq.com/s?__biz=MjM5MjAxNDM4MA==&amp;mid=2666274168&amp;idx=1&amp;sn=8aacbbf59630781ab98f6ba3342af81f&amp;chksm=bdb4743b8ac3fd2d1ef3b819cb26b6125e0802a1ab6067b4ddf836bb910bd24f06c77c2523eb&amp;mpshare=1&amp;scene=1&amp;srcid=&amp;sharer_sharetime=1569679494634&amp;sharer_shareid=cb69e8279d712b7b4136badae8a293b0#rd');
INSERT INTO short_url (id, title, md5, url_key, create_time, url_value) VALUES (1178122627998556161, '来了！新闻早班车', '8ed180baab703e9b8b2585c2baf71471', 'AB703E9B', 1569721297632, 'http://mp.weixin.qq.com/s?__biz=MjM5MjAxNDM4MA==&amp;mid=2666274352&amp;idx=1&amp;sn=51fc7e55802ce107a79298bc9a432420&amp;chksm=bdb477738ac3fe654a22edcee903b7efe5b635390a1eb71027205a6152cc9edd4459f0258add&amp;scene=0&amp;xtrack=1#rd');
INSERT INTO short_url (id, title, md5, url_key, create_time, url_value) VALUES (1178123216899809282, '早啊！新闻来了〔2019.09.29〕', '46025db9cf1846638ea267363d9be9e2', 'CF184663', 1569721438033, 'http://mp.weixin.qq.com/s?__biz=MTI0MDU3NDYwMQ==&amp;mid=2656805575&amp;idx=1&amp;sn=5097456c56d6a27f12d6e22457c087e5&amp;chksm=7a615f214d16d6372b7e520d1a4baee6c8eecc480471a7d512019de4cfde7d5bfa14acbc9051&amp;scene=0&amp;xtrack=1#rd');
INSERT INTO short_url (id, title, md5, url_key, create_time, url_value) VALUES (1178426318299340801, '早啊！新闻来了〔2019.09.30〕', 'ebc101b71575c991bea4e6e49f645722', '1575C991', 1569793703042, 'http://mp.weixin.qq.com/s?__biz=MTI0MDU3NDYwMQ==&amp;mid=2656806129&amp;idx=1&amp;sn=6b711562ad405004218e184655a75df5&amp;chksm=7a6159174d16d0012fbc3b503caf8fc60ca8dfa68395bd61ff62cd831022621fdd706242af62&amp;scene=0&amp;xtrack=1#rd');
INSERT INTO short_url (id, title, md5, url_key, create_time, url_value) VALUES (1178426432082419713, '来了！新闻早班车', '7a4cf63d5f3fe031393e22cff86f25a0', '5F3FE031', 1569793730165, 'http://mp.weixin.qq.com/s?__biz=MjM5MjAxNDM4MA==&amp;mid=2666274744&amp;idx=1&amp;sn=b25d2fa297505b91965683ae06bd6ec4&amp;chksm=bdb476fb8ac3ffed8b1dab251969a24d327d5d6ec39167e4fa73704c78c370f891bf4c5b8783&amp;scene=0&amp;xtrack=1#rd');
INSERT INTO short_url (id, title, md5, url_key, create_time, url_value) VALUES (1178505687193624577, '来了！新闻早班车', '3002936d266ae86411dc07462b543147', '266AE864', 1569812626060, 'http://mp.weixin.qq.com/s?__biz=MjM5MjAxNDM4MA==&amp;mid=2666274744&amp;idx=1&amp;sn=b25d2fa297505b91965683ae06bd6ec4&amp;chksm=bdb476fb8ac3ffed8b1dab251969a24d327d5d6ec39167e4fa73704c78c370f891bf4c5b8783&amp;mpshare=1&amp;scene=1&amp;srcid=&amp;sharer_sharetime=1569812294348&amp;sharer_shareid=9495b59240964dd7ba438decbdf4dc56#rd');
INSERT INTO short_url (id, title, md5, url_key, create_time, url_value) VALUES (1178505856853221378, '早啊！新闻来了〔2019.09.30〕', 'f55d77e7ccdaec012c281817dfcc2fa3', 'CCDAEC01', 1569812666507, 'http://mp.weixin.qq.com/s?__biz=MTI0MDU3NDYwMQ==&amp;mid=2656806129&amp;idx=1&amp;sn=6b711562ad405004218e184655a75df5&amp;chksm=7a6159174d16d0012fbc3b503caf8fc60ca8dfa68395bd61ff62cd831022621fdd706242af62&amp;mpshare=1&amp;scene=1&amp;srcid=&amp;sharer_sharetime=1569812664262&amp;sharer_shareid=9495b59240964dd7ba438decbdf4dc56#rd');
INSERT INTO short_url (id, title, md5, url_key, create_time, url_value) VALUES (1178789278247034882, '来了！新闻早班车', '80f01650d8b97734b2e8ea765f7fb1a3', 'D8B97734', 1569880239435, 'http://mp.weixin.qq.com/s?__biz=MjM5MjAxNDM4MA==&amp;mid=2666274999&amp;idx=1&amp;sn=c9a8ec0ddbcbd1d67f3427e2280ade33&amp;chksm=bdb449f48ac3c0e270a464252fca550761aecfc0357cb181e4d5229a484fd0409200edc69fdb&amp;scene=0&amp;xtrack=1#rd');
INSERT INTO short_url (id, title, md5, url_key, create_time, url_value) VALUES (1180597786802135041, '早啊！新闻来了〔2019.10.06〕', 'eb4e8d5eb313dc92dc9a11269b34d57a', 'B313DC92', 1570311421476, 'http://mp.weixin.qq.com/s?__biz=MTI0MDU3NDYwMQ==&amp;mid=2656808733&amp;idx=1&amp;sn=64f8eba1c6b414aef0a9cfc287db9aed&amp;chksm=7a6152fb4d16dbed6fa436b79b6490bb1fbf2546aef324f2ed8df4bb539a5ad5b136bd3c0876&amp;scene=0&amp;xtrack=1#rd');
