CREATE TABLE books (
    id BIGSERIAL PRIMARY KEY,          -- 자동 증가하는 ID 필드
    title VARCHAR(255) NOT NULL,        -- 책 제목
    author VARCHAR(255) NOT NULL,       -- 저자 이름
    price DECIMAL(10, 2) NOT NULL,      -- 책 가격 (소수점 2자리)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 생성 시간, 기본값은 현재 시간
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
);
