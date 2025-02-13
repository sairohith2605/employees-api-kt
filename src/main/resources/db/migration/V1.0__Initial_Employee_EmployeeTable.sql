-- V1.0__Initial_Employee_EmployeeTable
-- Creates a new table for employees with appropriate CHECK constraints and suitable INDEXES

CREATE TABLE employees (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    created_by VARCHAR(50) NOT NULL DEFAULT 'SYSTEM',
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT current_timestamp(),
    last_modified_by VARCHAR(50) NOT NULL DEFAULT 'SYSTEM',
    last_modified_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT current_timestamp(),
    is_active BOOLEAN NOT NULL DEFAULT true,
    first_name VARCHAR(128) NOT NULL,
    middle_name VARCHAR(128),
    last_name VARCHAR(128) NOT NULL,
    date_of_birth DATE NOT NULL,
    mobile VARCHAR(14) NOT NULL,
    alternate_mobile VARCHAR(14),
    date_of_joining DATE NOT NULL,

    CONSTRAINT chk_mobile_format CHECK (mobile ~ '^[0-9+][0-9-]{10,13}$'),
    CONSTRAINT chk_alternate_mobile_format CHECK (alternate_mobile IS NULL OR alternate_mobile ~ '^[0-9+][0-9-]{10,13}$'),
    CONSTRAINT chk_dob_valid CHECK (date_of_birth < (current_date - INTERVAL '18 years')),
    CONSTRAINT chk_doj_valid CHECK (date_of_joining >= (date_of_birth + INTERVAL '18 years'))
);

CREATE INDEX idx_employees_name ON employees(first_name, last_name) WHERE is_active = true;
CREATE INDEX idx_employees_doj ON employees(date_of_joining) WHERE is_active = true;
