CREATE TABLE sys_user (
                          id SERIAL PRIMARY KEY,
                          username VARCHAR(100) NOT NULL,
                          password VARCHAR(100) NOT NULL,
                          email VARCHAR(255),
                          phone VARCHAR(20),
                          avatar VARCHAR(255),
                          status INTEGER,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON TABLE sys_user IS '用户表';
COMMENT ON COLUMN sys_user.id IS '用户ID';
COMMENT ON COLUMN sys_user.username IS '用户名';
COMMENT ON COLUMN sys_user.password IS '密码';
COMMENT ON COLUMN sys_user.email IS '邮箱';
COMMENT ON COLUMN sys_user.phone IS '手机号';
COMMENT ON COLUMN sys_user.avatar IS '头像';
COMMENT ON COLUMN sys_user.status IS '状态';
COMMENT ON COLUMN sys_user.created_at IS '创建时间';
COMMENT ON COLUMN sys_user.updated_at IS '更新时间';

CREATE TABLE str_method (
                            id SERIAL PRIMARY KEY,
                            method_name VARCHAR(100) NOT NULL,
                            method_description TEXT,
                            method_class_object VARCHAR(255),
                            method_class_method VARCHAR(255),
                            method_class_parameters JSONB,
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON TABLE str_method IS '底层方法表';

COMMENT ON COLUMN str_method.id IS '方法ID';
COMMENT ON COLUMN str_method.method_name IS '方法名称';
COMMENT ON COLUMN str_method.method_description IS '方法描述';
COMMENT ON COLUMN str_method.method_class_object IS '方法类对象';
COMMENT ON COLUMN str_method.method_class_method IS '方法类方法';
COMMENT ON COLUMN str_method.method_class_parameters IS '方法类参数';
COMMENT ON COLUMN str_method.created_at IS '创建时间';
COMMENT ON COLUMN str_method.updated_at IS '更新时间';


CREATE TABLE str_step (
                          id SERIAL PRIMARY KEY,
                          step_name VARCHAR(100) NOT NULL,
                          step_description TEXT,
                          method_id INT,
                          step_class_parameters JSONB,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON TABLE str_step IS '步骤表';

COMMENT ON COLUMN str_step.id IS '步骤ID';
COMMENT ON COLUMN str_step.step_name IS '步骤名称';
COMMENT ON COLUMN str_step.step_description IS '步骤描述';
COMMENT ON COLUMN str_step.method_id IS '底层方法ID';
COMMENT ON COLUMN str_step.step_class_parameters IS '步骤类参数';
COMMENT ON COLUMN str_step.created_at IS '创建时间';
COMMENT ON COLUMN str_step.updated_at IS '更新时间';

CREATE TABLE str_flow (
                          id SERIAL PRIMARY KEY,
                          flow_name VARCHAR(100) NOT NULL,
                          flow_description TEXT,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          status INTEGER,
                          creator VARCHAR(100),
                          updater VARCHAR(100)
);

COMMENT ON TABLE str_flow IS '流程表';

COMMENT ON COLUMN str_flow.id IS '流程ID';
COMMENT ON COLUMN str_flow.flow_name IS '流程名称';
COMMENT ON COLUMN str_flow.flow_description IS '流程描述';
COMMENT ON COLUMN str_flow.created_at IS '创建时间';
COMMENT ON COLUMN str_flow.updated_at IS '更新时间';
COMMENT ON COLUMN str_flow.status IS '状态';
COMMENT ON COLUMN str_flow.creator IS '创建人';
COMMENT ON COLUMN str_flow.updater IS '更新人';


CREATE TABLE str_flow_step (
                               id SERIAL PRIMARY KEY,
                               flow_id INT,
                               step_id INT,
                               created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON TABLE str_flow_step IS '流程与步骤关联表';

COMMENT ON COLUMN str_flow_step.id IS '关联ID';
COMMENT ON COLUMN str_flow_step.flow_id IS '流程ID';
COMMENT ON COLUMN str_flow_step.step_id IS '步骤ID';
COMMENT ON COLUMN str_flow_step.created_at IS '创建时间';
COMMENT ON COLUMN str_flow_step.updated_at IS '更新时间';




