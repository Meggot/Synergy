CREATE TABLE Passwords(
    pk_pwd_id INTEGER PRIMARY KEY IDENTITY,
    salt varchar(100) NOT NULL,
    hash_value varchar(100) NOT NULL,
    creation_date DATE NOT NULL,
    modified_date DATE NOT NULL,
    deleted INTEGER DEFAULT 0,
    oca INTEGER DEFAULT 1
)
CREATE TABLE Accounts(
   pk_user_id INTEGER PRIMARY KEY IDENTITY,
   fk_pwd_id INTEGER FOREIGN KEY REFERENCES Passwords(pk_pwd_id),
   account_type INTEGER DEFAULT 1,
   username varchar(25) NOT NULL,
   email varchar(50) NOT NULL,
   dob DATE DEFAULT NULL,
   creation_date DATE NOT NULL,
   modified_date DATE NOT NULL,
   deleted INTEGER DEFAULT 0,
   oca INTEGER DEFAULT 1
)
CREATE TABLE Projects(
    pk_project_id INTEGER PRIMARY KEY IDENTITY,
    fk_owner_id INTEGER FOREIGN KEY REFERENCES Accounts(pk_user_id),
    title VARCHAR(255) NOT NULL,
    synopsis varchar(255) NOT NULL,
    creation_date DATE NOT NULL,
    modified_date DATE NOT NULL,
    deleted INTEGER DEFAULT 0,
    oca INTEGER DEFAULT 1
)
CREATE TABLE Project_Parts(
    pk_project_part_id INTEGER PRIMARY KEY IDENTITY,
    fk_project_id INTEGER FOREIGN KEY REFERENCES Projects(pk_project_id),
    part_position INTEGER NOT NULL,
    body VARCHAR(255) NOT NULL,
    creation_date DATE NOT NULL,
    modified_date DATE NOT NULL,
    deleted INTEGER DEFAULT 0,
    oca INTEGER DEFAULT 1
)
CREATE TABLE Authors(
   pk_author_id INTEGER PRIMARY KEY IDENTITY,
   fk_project_part_id INTEGER FOREIGN KEY REFERENCES Project_Parts(pk_project_part_id),
   fk_account_id INTEGER FOREIGN KEY REFERENCES Accounts(pk_user_id),
   ownership_level INTEGER NOT NULL,
    creation_date DATE NOT NULL,
    modified_date DATE NOT NULL,
    deleted INTEGER DEFAULT 0,
    oca INTEGER DEFAULT 1
)
CREATE TABLE Project_Settings (
   pk_setting_id INTEGER PRIMARY KEY IDENTITY,
   fk_project_id INTEGER FOREIGN KEY REFERENCES Projects(pk_project_id),
   key VARCHAR(25) NOT NULL,
   value VARCHAR(255) NOT NULL,
   creation_date DATE NOT NULL,
   modified_date DATE NOT NULL,
   deleted INTEGER DEFAULT 0,
   oca INTEGER DEFAULT 1
)
CREATE TABLE Project_Tags(
   pk_tag_id INTEGER PRIMARY KEY IDENTITY,
   fk_project_id INTEGER FOREIGN KEY REFERENCES Projects(pk_project_id),
   value VARCHAR(255) DEFAULT NULL,
   creation_date DATE NOT NULL,
   modified_date DATE NOT NULL,
   deleted INTEGER DEFAULT 0,
   oca INTEGER DEFAULT 1
)
CREATE TABLE Project_Audits(
    pk_audit_id INTEGER PRIMARY KEY,
    fk_project_id INTEGER FOREIGN KEY REFERENCES Projects(pk_project_id),
    value VARCHAR(255) DEFAULT NULL,
   creation_date DATE NOT NULL,
   modified_date DATE NOT NULL,
   deleted INTEGER DEFAULT 0,
   oca INTEGER DEFAULT 1
)
CREATE TABLE User_Audits(
    pk_audit_id INTEGER PRIMARY KEY,
    fk_account_id INTEGER FOREIGN KEY REFERENCES Accounts(pk_user_id),
    value VARCHAR(255) DEFAULT NULL,
   creation_date DATE NOT NULL,
   modified_date DATE NOT NULL,
   deleted INTEGER DEFAULT 0,
   oca INTEGER DEFAULT 1
);

CREATE TABLE Project_Part_Votes(
    pk_project_part_votes_id INTEGER PRIMARY KEY,
    fk_project_part_id INTEGER FOREIGN KEY REFERENCES Project_Parts(pk_project_part_id),
    fk_account_id INTEGER FOREIGN KEY REFERENCES Accounts(pk_fk_account_id),
    vote INTEGER(1) NOT NULL,
    creation_date DATE NOT NULL,
    modified_date DATE NOT NULL,
    deleted INTEGER DEFAULT 0,
    oca INTEGER DEFAULT 1,
    CONSTRAINT allowed_vote_values (vote == 1 OR vote == -1)
    );

CREATE TABLE Project_Meta_Data(
    pk_project_meta_data_id INTEGER PRIMARY KEY,
    fk_project_id INTEGER FOREIGN KEY REFERENCES Projects(pk_project_id),
    upvotes INTEGER DEFAULT 0,
    downvotes INTEGER DEFAULT 0
    favourites INTEGER DEFAULT 0,
    shares INTEGER DEFAULT 0,
    creation_date DATE NOT NULL,
    modified_date DATE NOT NULL,
    deleted INTEGER DEFAULT 0,
    oca INTEGER DEFAULT 1
    );