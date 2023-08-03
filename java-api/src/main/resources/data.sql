INSERT INTO bonds
    (coupon_percent, bond_currency, cusip, face_value, isin, issuer_name, bond_maturity, status, type)
VALUES
    (2.02, 'USD', '87973RAA8', 690, 'US87973RAA86', 'TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S', '06/08/2021', 'active', 'SOVN'),
    (3.15, 'USD', 'AMZN 3.15 08/22/27 REGS', 900, 'USU02320AG12', 'Amazon', '03/08/2021', 'active', 'CORP'),
    (0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460510', 'HM Treasury United Kingdon', '09/08/2021', 'active', 'GOVN'),
    (0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460512', 'HM Treasury United Kingdon', '09/08/2021', 'active', 'GOVN'),
    (0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460505', 'HM Treasury United Kingdon', '09/08/2021', 'active', 'GOVN'),
    (0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460507', 'HM Treasury United Kingdon', '09/08/2021', 'active', 'GOVN'),
    (1.123, 'USD', '87973RAA8', 340, 'IE00B29LNP31', 'First Norway Alpha Kl.IV', '22/12/2030', 'active', 'SOVN'),
    (3.15, 'USD', '123456780', 900, 'USN0280EAR64', 'Airbus 3.15%  USD', '30/07/2021', 'active', 'CORP'),
    (0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460508', 'HM Treasury United Kingdon', '09/08/2021', 'active', 'GOVN'),
    (2, 'USD', '123456bh0', 900, 'A12356111', 'UBS Facebook (USD)', '30/09/2021', 'active', 'CORP'),
    (0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460515', 'HM Treasury United Kingdon', '09/08/2021', 'active', 'GOVN'),
    (0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460509', 'HM Treasury United Kingdon', '09/08/2021', 'active', 'GOVN'),
    (0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460514', 'HM Treasury United Kingdon', '09/08/2021', 'active', 'GOVN'),
    (4.37, 'USD', '', 1000, 'XS1988387210', 'BNPParibasIssu 4,37% Microsoft Corp (USD)', '05/08/2021', 'active', 'CORP'),
    (0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460513', 'HM Treasury United Kingdon', '09/08/2021', 'active', 'GOVN'),
    (0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460506', 'HM Treasury United Kingdon', '09/08/2021', 'active', 'GOVN'),
    (0.75, 'GBP', 'BDCHBW8', 900, 'GB00B6460511', 'HM Treasury United Kingdon', '09/08/2021', 'active', 'GOVN'),

INSERT INTO users
    (name, email, role)
VALUES
    ('admin', 'admin@email.com', 'CEO');

INSERT INTO books
    (name)
VALUES
    ('trading_book_1'),
    ('trading_book_2'),
    ('trading_book_3'),
    ('trading_book_4'),
    ('trading_book_5');

INSERT INTO book_users
    (book_id, user_id)
VALUES
    (1, 1),
    (2, 1),
    (3, 1),
    (4, 1),
    (5, 1);

INSERT INTO counterparties
    (name)
VALUES
    ('Acme co'), --1
    ('Astra Trading Ltd'), --2
    ('AZ Holdings Inc'), --3
    ('Barclays'), --4
    ('British Telecom'), --5
    ('Goldman Sachs'), --6
    ('Muncipal Gov Of Orange County'), --7
    ('Pension Holdings'), --8
    ('Sovereign Investments'), --9
    ('UBS'), --10
    ('Zurich Pension fund 4'); --11

INSERT INTO trades
    (type, currency, quantity, settlement_date, status, trade_date, unit_price, bond_id, book_id, counterparty_id)
VALUES
    ('buy', 'USD', 50, '04/08/2021', 'open', '13/05/2021', 90, 'XS1988387210', 1, 3),
    ('sell', 'GBP', 40, '04/08/2021', 'open', '04/02/2021', 89.56, 'XS1988387210', 1, 3),
    ('buy', 'USD', 1000, '23/08/2021', 'open', '13/05/2021', 105.775, 'USN0280EAR64', 2, 1),
    ('sell', 'GBP', 900, '10/09/2021', 'open', '04/02/2021', 105.775, 'USN0280EAR64', 2, 1),
    ('buy', 'USD', 50, '23/08/2021', 'open', '13/05/2021', 90, 'A12356111', 3, 9),
    ('buy', 'USD', 1000, '23/08/2021', 'open', '13/05/2021', 105.775, 'USN0280EAR64', 2, 2),
    ('sell', 'USD', 50, '23/08/2021', 'open', '13/05/2021', 90, 'A12356111', 2, 9),
    ('buy', 'GBP', 60, '27/09/2021', 'open', '04/02/2021', 98.56, 'USU02320AG12', 4, 7),
    ('buy', 'USD', 50, '23/08/2021', 'open', '23/08/2021', 98.56, 'USU02320AG12', 4, 7),
    ('buy', 'GBP', 1100, '27/09/2021', 'open', '27/09/2021', 110.35, 'GB00B6460505', 5, 6),
    ('sell', 'GBP', 900, '28/09/2021', 'open', '28/09/2021', 110.35, 'GB00B6460506', 5, 6),
    ('buy', 'GBP', 2000, '29/09/2021', 'open', '29/09/2021', 110.35, 'GB00B6460507', 5, 10),
    ('sell', 'GBP', 2000, '30/09/2021', 'open', '30/09/2021', 110.35, 'GB00B6460508', 5, 10),
    ('buy', 'GBP', 1000, '01/10/2021', 'open', '01/10/2021', 110.35, 'GB00B6460509', 5, 4),
    ('buy', 'GBP', 900, '02/10/2019', 'open', '02/10/2019', 110.35, 'GB00B6460510', 5, 4),
    ('sell', 'GBP', 1900, '03/10/2019', 'open', '03/10/2019', 110.35, 'GB00B6460511', 5, 4),
    ('buy', 'GBP', 600, '04/10/2018', 'open', '04/10/2018', 110.35, 'GB00B6460512', 5, 5),
    ('buy', 'GBP', 600, '05/10/2019', 'open', '05/10/2019', 110.35, 'GB00B6460513', 5, 8),
    ('buy', 'GBP', 700, '06/06/2021', 'open', '06/06/2021', 110.35, 'GB00B6460514', 5, 8),
    ('sell', 'GBP', 1300, '07/10/2021', 'open', '07/10/2011', 110.35, 'GB00B6460515', 5, 8),
    ('buy', 'USD', 60, '27/09/2021', 'open', '04/02/2012', 100.13, 'US87973RAA86', 4, 11),
    ('buy', 'USD', 50, '23/08/2021', 'open', '23/08/2012', 100.13, 'US87973RAA86', 4, 11),
    ('buy', 'USD', 75, '27/09/2021', 'open', '04/02/2013', 100.13, 'US87973RAA86', 4, 11),
    ('buy', 'USD', 50, '23/08/2021', 'open', '23/08/2014', 100.13, 'US87973RAA86', 4, 11),
    ('buy', 'USD', 300, '27/09/2021', 'open', '04/02/2016', 98.76, 'IE00B29LNP31', 4, 11),
    ('buy', 'USD', 300, '23/08/2021', 'open', '23/08/2012', 98.76, 'IE00B29LNP31', 4, 11),
    ('buy', 'USD', 300, '27/09/2021', 'open', '04/02/2013', 98.76, 'IE00B29LNP31', 4, 11),
    ('sell', 'USD', 300, '23/08/2021', 'open', '23/08/2015', 98.76, 'IE00B29LNP31', 4, 11);