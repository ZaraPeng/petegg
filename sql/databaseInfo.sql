CREATE TABLE `pet_status` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `pet_info_id` bigint(30) NOT NULL COMMENT '宠物信息表id',
  `hunger` bigint(30) NOT NULL COMMENT '饥饿值',
  `clean` bigint(30) NOT NULL COMMENT '清洁值',
  `smarts` bigint(30) NOT NULL COMMENT '智慧值',
  `active` bigint(30) NOT NULL COMMENT '活力值',
  `energy` bigint(30) NOT NULL COMMENT '体力值',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `happy` bigint(30) NOT NULL COMMENT '开心值',
  PRIMARY KEY (`id`),
  KEY `idx_pet_info_id` (`pet_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='宠物状态表';

CREATE TABLE `pet_info` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `pet_gamer_id` bigint(30) NOT NULL COMMENT '玩家id',
  `name` varchar(50) NOT NULL COMMENT '宠物姓名',
  `sex` tinyint(4) NOT NULL COMMENT '性别 0 女 1男',
  `weight` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '体重',
  `stage` tinyint(4) NOT NULL COMMENT '阶段 0 婴儿 1 幼儿 2 少年 3 青年 3 中年 4 老年',
  `type` tinyint(4) NOT NULL COMMENT '宠物类型 0 独角兽 1 章鱼',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '宠物状态 0 不可见 1 可见',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_gamerid_status` (`pet_gamer_id`,`status`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='宠物信息表';

CREATE TABLE `pet_gamer` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `pet_info_id` bigint(30) DEFAULT NULL COMMENT '宠物信息id',
  `weixin_openid` varchar(200) NOT NULL COMMENT '微信openid',
  `weixin_name` varchar(200) DEFAULT NULL COMMENT '微信昵称',
  `weixin_head_image` varchar(500) DEFAULT NULL COMMENT '微信头像URL',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='玩家信息表';

CREATE TABLE `pet_cion` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `pet_gamer_id` bigint(30) NOT NULL COMMENT '玩家id',
  `number` bigint(30) NOT NULL DEFAULT '0' COMMENT '钱币个数',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_pet_gamer_id` (`pet_gamer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='钱币';