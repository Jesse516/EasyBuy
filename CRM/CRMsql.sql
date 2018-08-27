/* 数据库名称：jb_crm_team*/
CREATE DATABASE jb_crm_team
USE jb_crm_team

-- 1.用户信息表
CREATE TABLE sys_user(
usr_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '用户编号,自动增长,非空,主键-------------PK',
usr_name VARCHAR(50) NOT NULL COMMENT '用户名称,非空',
usr_password VARCHAR(50) NOT NULL COMMENT '用户密码,非空',
usr_role_id BIGINT COMMENT '角色编号,外键',
usr_flag INT(2) NOT NULL COMMENT '状态(0:已删除,1:正常)' 
)CHARSET=utf8;

SELECT * FROM sys_user WHERE usr_name='admin' AND usr_password='123' AND usr_flag=1

-- 2.角色表
CREATE TABLE sys_role(
role_id BIGINT NOT NULL  PRIMARY KEY COMMENT '角色编号,主键,非空,关联用户表',
role_name VARCHAR(50) NOT NULL COMMENT '角色名称',
role_desc VARCHAR() COMMENT '角色描述,可为空',
role_flag INT COMMENT '角色标记,可为空'
)CHARSET=utf8;

-- 3.权限/功能表
CREATE TABLE sys_right(
right_code VARCHAR(50) NOT NULL COMMENT '功能编号,主键，关联角色权限表表',
right_parent_code VARCHAR(50) COMMENT '父权限编号',
right_type VARCHAR(50) COMMENT '权限类型',
right_text VARCHAR(50) COMMENT '权限名称',
right_url VARCHAR(100) COMMENT 'url(权限对应功能的访问url)',
right_tip VARCHAR(50) COMMENT '权限提示文本'
)CHARSET=utf8;
 
/*4.角色权限表*/
CREATE TABLE sys_role_right(
rf_id BIGINT NOT NULL PRIMARY KEY COMMENT '系统角色权限关系编号，主键',
rf_role_id BIGINT NOT NULL COMMENT '角色编号,外键------FK',
rf_right_code VARCHAR(50) NOT NULL COMMENT '权限编号,外键------FK'
)CHARSET=utf8;

/*5.销售机会表*/
CREATE TABLE asl_chance(
chc_id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY COMMENT '机会编号,主键,自增-----------PK',
chc_source VARCHAR(50) COMMENT '机会来源',
chc_cust_name VARCHAR(100) NOT NULL COMMENT '客户名称',
chc_title VARCHAR(200) NOT NULL COMMENT '机会标题,概要',
chc_rate INT(200) NOT NULL COMMENT '成功几率',
chc_linkman VARCHAR(50) COMMENT '联系人',
chc_tel VARCHAR(50) COMMENT '联系电话',
chc_desc VARCHAR(2000) COMMENT '机会描述',
chc_create_id BIGINT NOT NULL COMMENT '创建人编号',
chc_create_by VARCHAR(50) NOT NULL COMMENT '创建人',
chc_create_date DATETIME NOT NULL COMMENT '创建时间',
chc_due_id BIGINT COMMENT '指派对象编号',
chc_due_to VARCHAR(50) COMMENT '指派对象姓名',
chc_due_date DATETIME COMMENT '指派时间',
chc_status VARCHAR(20) NOT NULL COMMENT '1--未指派,2--已指派,3--开发中,4--开发成功,5--终止开发,6--已归档'，
chc_isdelete INT(2) COMMENT '0 删除 1 正常'
)CHARSET=utf8;

/*6.开发计划表*/
CREATE TABLE sal_plan(
pla_id BIGINT NOT NULL PRIMARY KEY COMMENT '计划编号,主键--------PK',
pla_chc_id BIGINT NOT NULL COMMENT '机会编号,外键----------FK',
pla_date DATETIME NOT NULL COMMENT '计划制定时间',
pla_todo VARCHAR(500) NOT NULL COMMENT '计划项',
pla_result VARCHAR(500) NOT NULL COMMENT '执行结果:正在开发，开发完成，开发失败'
)CHARSET=utf8;		
				

	
/*7.客户表*/
CREATE TABLE cst_customer(
cust_no VARCHAR(17) NOT NULL PRIMARY KEY COMMENT '客户编号,主键---------------PK',
cust_name VARCHAR(100) NOT NULL COMMENT '客户名称',
cust_region VARCHAR(50) COMMENT '地区',
cust_manager_id BIGINT COMMENT '客户经理编号,外键-----------------PK',
cust_manager_name VARCHAR(50) COMMENT '客户经理',
cust_level INT COMMENT '客户等级: 战略合作伙伴 大客户 重点开发客户 普通客户 合作伙伴',
cust_level_label VARCHAR(50) COMMENT '客户等级标签',
cust_satisfy VARCHAR(50) COMMENT '满意度1-5',
cust_credit INT COMMENT '信用度1-5',
cust_addr VARCHAR(300) COMMENT '地址',
cust_zip VARCHAR(10) COMMENT '邮政编码',
cust_tel VARCHAR(50) COMMENT '电话',
cust_fax VARCHAR(50) COMMENT '传真',
cust_website VARCHAR(50) COMMENT '网址',
cust_licence_no VARCHAR(50) COMMENT '营业执照注册号',
cust_chieftain VARCHAR(10) COMMENT '法人',
cust_bankroll BIGINT COMMENT '注册资金',
cust_turnover BIGINT COMMENT '营业额',
cust_bank VARCHAR(200) COMMENT '开户银行',
cust_bank_account VARCHAR(50) COMMENT '银行账号',
cust_local_tax_no VARCHAR(50) COMMENT '地税登记号',
cust_national_tax_no VARCHAR(50) COMMENT '国税登记号',
cust_status INT(2) COMMENT '状态1--正常,2--流失,3--删除'
)CHARSET=utf8;



/*8.客户联系人表*/

CREATE TABLE cst_linkman(
lkm_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '联系人编号,主键--------PK',
lkm_cust_no VARCHAR(17) NOT NULL COMMENT '客户编号,外键----------FK',
lkm_name VARCHAR(50) COMMENT '联系人姓名',
lkm_sex VARCHAR(50) COMMENT '联系人性别',
lkm_postion VARCHAR(50) COMMENT '联系人职位',
lkm_tel VARCHAR(50) COMMENT '联系人办公电话',
lkm_mobile VARCHAR(50) COMMENT '联系人手机',
lkm_memo VARCHAR(300) COMMENT '备注',
lkm_status INT(4) COMMENT '状态(0:已删除,1:正常)' 



)CHARSET=utf8;

/*9.客户交往记录表*/	
CREATE TABLE cst_activity(
atv_id BIGINT NOT NULL PRIMARY KEY COMMENT '记录编号,主键--------PK',
atv_cust_no VARCHAR(17) COMMENT '客户编号,外键----------FK',
atv_cust_name VARCHAR(100) COMMENT '客户姓名',
atv_date DATETIME NOT NULL COMMENT '交往时间',
atv_place VARCHAR(200) NOT NULL COMMENT '地点',
atv_title VARCHAR(500) NOT NULL COMMENT '概要',
atv_desc VARCHAR(200) NOT NULL COMMENT '详细信息',
atv_memo VARCHAR(300) COMMENT '备注'
)CHARSET=utf8;
	
	
/*13.历史订单表*/	
CREATE TABLE orders(
odr_id	BIGINT NOT NULL PRIMARY KEY COMMENT '订单编号,PK----------主键',
odr_customerno VARCHAR(17) NOT NULL COMMENT '客户编号,FK------------外键',	
odr_customer VARCHAR(100) NOT NULL COMMENT '客户姓名',	
odr_date DATETIME NOT NULL COMMENT '下单时间',	
odr_addr VARCHAR(200) COMMENT '送货地址',	
odr_status VARCHAR(20) NOT NULL COMMENT '状态:1-新创建2-已确认3-正配货4-已发货5-正在派件6-已回款',
odr_isdelete INT(2) COMMENT '0 删除 1 正常'
)CHARSET=utf8;

SELECT * FROM orders WHERE odr_customerno=1001


SELECT * FROM orders WHERE odr_isdelete=1 AND odr_customerno=1001 LIMIT 0,2
/*14.订单详细信息表*/	
CREATE TABLE orders_line(
odd_id BIGINT NOT NULL PRIMARY KEY COMMENT '编号,PK----------主键',
odd_order_id BIGINT NOT NULL COMMENT '订单编号,FK------------外键',
odd_prod_id BIGINT NOT NULL COMMENT '产品编号,FK------------外键',	
odd_count INT NOT NULL COMMENT '数量',	
odd_unit VARCHAR(10) COMMENT '单位',	
odd_price DOUBLE COMMENT '单价'，
odd_isdelete INT(2) COMMENT '0 删除 1 正常'
)CHARSET=utf8;

SELECT o.* ,l.* FROM orders o 
LEFT JOIN orders_line l ON o.odr_id = l.odd_order_id 
-- left join  orders_product p ON l.`odd_order_id` = p.prod_id
WHERE odr_id=1 

SELECT o.* ,p.prod_name AS prod_name FROM orders_line o,orders_product p WHERE odd_isdelete=1 AND o.odd_order_id=p.prod_id
SELECT o.* ,p.prod_name AS prod_name FROM orders_line o,orders_product p WHERE odd_isdelete=1 AND o.odd_prod_id=p.prod_id

/*订单详情表关联订单表*/
ALTER TABLE orders_line ADD CONSTRAINT  fk_line_orders  FOREIGN KEY(`odd_order_id`) REFERENCES orders(`odr_id`);
/*订单详情表关联商品表*/
ALTER TABLE orders_line ADD CONSTRAINT  fk_line_product  FOREIGN KEY(`odd_prod_id`) REFERENCES orders_product(`prod_id`);

/*15.产品表*/	
CREATE TABLE orders_product(
prod_id BIGINT NOT NULL PRIMARY KEY COMMENT '产品编号,PK----------主键',
prod_name VARCHAR(200) NOT NULL COMMENT '产品名称',
prod_type VARCHAR(100) NOT NULL COMMENT '产品型号',	
prod_batch VARCHAR(100) COMMENT '产品批次',	
prod_unit VARCHAR(10) COMMENT '产品单位',	
prod_price DOUBLE COMMENT '单价',
prod_memo VARCHAR(200) COMMENT '备注'，`orders_line`
prod_isdelete INT(2) COMMENT '0 删除 1 正常'
)CHARSET=utf8;


/*16.库存表*/	
CREATE TABLE storages(
stk_id BIGINT NOT NULL PRIMARY KEY COMMENT '库存编号,PK----------主键',
stk_prod_id BIGINT NOT NULL COMMENT '产品编号,FK----------外键',
stk_warehouse VARCHAR(50) NOT NULL COMMENT '仓库',	
stk_ware VARCHAR(50) NOT NULL COMMENT '货位',	
stk_count INT NOT NULL COMMENT '件数',	
stk_memo VARCHAR(200) COMMENT '备注'
)CHARSET=utf8;	
	
/*库存表关联商品表*/
ALTER TABLE storages ADD CONSTRAINT  fk_store_product  FOREIGN KEY(`stk_prod_id`) REFERENCES orders_product(`prod_id`);	
	
/*10.客户流失表*/	
CREATE TABLE cst_lost(
lst_id BIGINT NOT NULL PRIMARY KEY COMMENT '流失编号,主键--------PK',
lst_cust_no VARCHAR(17) NOT NULL COMMENT '客户编号,外键----------FK',
lst_cust_name VARCHAR(100) COMMENT '客户姓名',
lst_manager_id BIGINT NOT NULL COMMENT '客户经理编号',
lst_manager_name VARCHAR(50) NOT NULL COMMENT '客户经理',
lst_last_order_date DATETIME COMMENT '上次下单时间',
lst_lost_date DATETIME COMMENT '确认流失时间',
lst_delay VARCHAR(4000) COMMENT '暂缓措施',
lst_reason VARCHAR(2000) COMMENT '流失原因',
lst_status VARCHAR(50) NOT NULL COMMENT '状态1-警告，2-暂缓流失，3-已经流失'
)CHARSET=utf8;	

SELECT l.*,c.

SELECT *,YEAR(lst_lost_date) lostyear FROM cst_lost






/*11.客户服务表*/	
CREATE TABLE cst_service(
svr_id BIGINT NOT NULL PRIMARY KEY COMMENT '服务编号,主键--------PK',
svr_type VARCHAR(20) NOT NULL COMMENT '服务类型 咨询 投诉 建议',
svr_title VARCHAR(500) NOT NULL COMMENT '服务概要',
svr_cust_no VARCHAR(17) COMMENT '客户编号,外键----------FK',
svr_cust_name VARCHAR(100) NOT NULL COMMENT '客户姓名',
svr_status VARCHAR(10) NOT NULL COMMENT '状态',
svr_request VARCHAR(3000) NOT NULL COMMENT '服务请求',
svr_create_id BIGINT NOT NULL COMMENT '创建人编号',
svr_create_by VARCHAR(50) NOT NULL COMMENT '创建人',
svr_create_date DATETIME NOT NULL COMMENT '创建时间',
svr_due_id BIGINT COMMENT '分配给某人的编号(客户经理编号)',
svr_due_to VARCHAR(50) COMMENT '分配给xx的姓名',
svr_due_date DATETIME COMMENT '分配时间',
svr_deal VARCHAR(3000) COMMENT '服务处理',
svr_deal_id BIGINT COMMENT '处理人编号',
svr_deal_by VARCHAR(50) COMMENT '处理人',
svr_deal_date DATETIME COMMENT '处理时间',
svr_result VARCHAR(50) COMMENT '处理结果',
svr_satisfy INT COMMENT '满意度'
)CHARSET=utf8;
SELECT DATE(svr_create_date)>DATE("2018-03-19")   FROM cst_service
SELECT DATE("2018-03-19")   FROM DUAL
 SELECT * FROM cst_service WHERE 1=1   AND DATE(svr_create_date) > DATE('2018-07-18')
 SELECT DATE(svr_create_date) FROM cst_service

SELECT * FROM cst_service WHERE UNIX_TIMESTAMP(svr_create_date)>  UNIX_TIMESTAMP("2018-03-19")   FROM DUAL

SELECT svr_type,COUNT(svr_type) number FROM cst_service WHERE 1=1 AND  YEAR(svr_create_date)=2018 GROUP BY  svr_type


/*12.基础数据表*/	
CREATE TABLE bas_activity(
dict_id	BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '编号',
dict_type VARCHAR(50) NOT NULL COMMENT '类别',	
dict_item VARCHAR(50) NOT NULL COMMENT '条目',	
dict_value VARCHAR(50) NOT NULL COMMENT '值',	
dict_id_editable VARCHAR(20) NOT NULL COMMENT '是否可编辑:0-- 不可以 1-- 可以'
)CHARSET=utf8;



		


	









SELECT UNIX_TIMESTAMP(now()) FROM DUAL
SELECT NOW() FROM DUAL


select *from orders where unix_timestamp(odr_date) >= unix_timestamp("2018-06-03 00:00:00")


SELECT UNIX_TIMESTAMP(odr_date) FROM orders 



SELECT year(odr_date) FROM orders 

SELECT month(odr_date) FROM orders 
SELECT hour(odr_date) FROM orders 
SELECT minute(odr_date) FROM orders 
SELECT HOUR(odr_date) FROM orders 

SELECT *FROM orders WHERE YEAR(odr_date)=2018


select count(distinct cust_level_label) from cst_customer	


SELECT  cust_level,cust_name,count(cust_name) `count` FROM cst_customer where cust_status<>3 group by cust_level_label

select a.cust_no,a.cust_name, b.num from cst_customer a,(SELECT COUNT(1) as num FROM cst_customer   b GROUP BY cust_level_label) WHERE a.cust_no=b.cust_no


select * from orders where odr_isdelete=1 group by odr_customerno



