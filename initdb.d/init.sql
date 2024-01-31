DROP SCHEMA IF EXISTS demo_database;
CREATE SCHEMA demo_database;
USE demo_database;

/** ショップ */
DROP TABLE IF EXISTS users;
CREATE TABLE users(
  id INT(10) NOT NULL AUTO_INCREMENT,
  fist_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  address VARCHAR(100) NOT NULL,
  create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY(id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

/** 初期データ挿入 */
insert into users (fist_name, last_name, address) values
    ('ファースト1', 'ラスト1', '〇〇〇〇〇〇'),
    ('ファースト2', 'ラスト2', '〇〇〇〇〇〇')
    ('ファースト3', 'ラスト3', '〇〇〇〇〇〇');