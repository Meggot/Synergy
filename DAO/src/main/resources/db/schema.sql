CREATE TABLE Passwords(
    pk_pwd_id INTEGER PRIMARY KEY IDENTITY,
    salt varchar(100) NOT NULL,
    hash_value varchar(100) NOT NULL,
    creation_date DATE DEFAULT NULL,
    modified_date DATE DEFAULT NULL,
    deleted INTEGER NOT NULL,
    oca INTEGER NOT NULL
)
CREATE TABLE Accounts(
   pk_user_id INTEGER PRIMARY KEY IDENTITY,
   fk_pwd_id INTEGER FOREIGN KEY REFERENCES Password(pk_pwd_id),
   username varchar(25) DEFAULT NULL,
   email varchar(50) DEFAULT NULL,
   dob DATE DEFAULT NULL,
   creation_date DATE DEFAULT NULL,
   modified_date DATE DEFAULT NULL,
   deleted INTEGER NOT NULL,
   oca INTEGER NOT NULL
)
CREATE TABLE Projects(
    pk_project_id INTEGER PRIMARY KEY IDENTITY,
    synopsis varchar(255) DEFAULT NULL,
    creation_date DATE DEFAULT NULL,
    modified_date DATE DEFAULT NULL,
    deleted INTEGER NOT NULL,
    oca INTEGER NOT NULL
)
CREATE TABLE Paragraph(
    pk_paragraph_id INTEGER PRIMARY KEY IDENTITY,
    fk_project_id INTEGER FOREIGN KEY REFERENCES Project(pk_project_id),
    fk_user_id INTEGER FOREIGN KEY REFERENCES Account(pk_user_id),
    creation_date DATE NOT NULL,
    modified_date DATE DEFAULT NULL,
    paragraph_position INTEGER,
    body VARCHAR(255) DEFAULT NULL
)
CREATE TABLE Authors(
   pk_author_id INTEGER PRIMARY KEY IDENTITY,
   fk_project_id INTEGER FOREIGN KEY REFERENCES Project(pk_project_id),
   fk_account_id INTEGER FOREIGN KEY REFERENCES Account(pk_user_id),
   authorship_date DATE DEFAULT NULL,
   ownership_level INTEGER NOT NULL
)
CREATE TABLE Project_Settings(
   fk_project_id INTEGER FOREIGN KEY REFERENCES Project(pk_project_id),
   key VARCHAR(25) DEFAULT NULL,
   value VARCHAR(255) DEFAULT NULL,
   creation_date DATE DEFAULT NULL,
   modified_date DATE DEFAULT NULL,
   oca INTEGER DEFAULT NULL
)
CREATE TABLE Project_Tags(
   fk_project_id INTEGER FOREIGN KEY REFERENCES Project(pk_project_id),
   tag_value VARCHAR(255) DEFAULT NULL,
   creation_date DATE DEFAULT NULL
)
CREATE TABLE User_Levels(
  fk_account_id INTEGER FOREIGN KEY REFERENCES Account(pk_user_id),
  user_level INTEGER DEFAULT NULL
)
CREATE TABLE Project_Audits(
    pk_audit_id INTEGER PRIMARY KEY,
    fk_project_id INTEGER FOREIGN KEY REFERENCES Project(pk_project_id),
    value VARCHAR(255) DEFAULT NULL,
    timestamp DATE DEFAULT NULL
)
CREATE TABLE User_Audits(
    pk_audit_id INTEGER PRIMARY KEY,
    fk_account_id INTEGER FOREIGN KEY REFERENCES Account(pk_user_id),
    value VARCHAR(255) DEFAULT NULL,
    timestamp DATE DEFAULT NULL
);