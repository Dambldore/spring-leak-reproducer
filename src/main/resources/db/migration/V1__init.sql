CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE public.commands (
    id UUID NOT NULL DEFAULT uuid_generate_v1 (),
    capacity INTEGER,
    PRIMARY KEY(id)
);
