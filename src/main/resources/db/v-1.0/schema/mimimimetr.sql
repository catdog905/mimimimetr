CREATE SCHEMA mimimimetr;

CREATE TABLE mimimimetr.cat
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR NOT NULL,
    image BYTEA   NOT NULL,
    grade DECIMAL NOT NULL
);

CREATE FUNCTION mimimimetr.avg_grade() RETURNS DECIMAL
AS
$$
SELECT avg(c.grade)
FROM mimimimetr.cat c
$$
    LANGUAGE SQL;

ALTER TABLE mimimimetr.cat
    ALTER COLUMN grade
        SET DEFAULT coalesce(mimimimetr.avg_grade(), 0);

CREATE INDEX mimimimetr_cat_grade_b_tree_index ON mimimimetr.cat (grade);

CREATE TABLE mimimimetr.active_session
(
    token    UUID PRIMARY KEY,
    is_voted BOOL NOT NULL
);

CREATE TABLE mimimimetr.voting
(
    session       UUID REFERENCES mimimimetr.active_session (token) NOT NULL,
    first_cat_id  INTEGER REFERENCES mimimimetr.cat (id)            NOT NULL,
    second_cat_id INTEGER REFERENCES mimimimetr.cat (id)            NOT NULL,
    decision      BOOL                                              NOT NULL,
    PRIMARY KEY (session, first_cat_id, second_cat_id)
);