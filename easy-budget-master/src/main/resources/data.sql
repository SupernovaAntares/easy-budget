INSERT INTO account (name, account_Value, currency,notes) VALUES ('TESTE', '200', 'BRL-R$','Conta teste');
INSERT INTO account (name, account_Value, currency,notes) VALUES ('TESTE2', '300', 'BRL-R$','Conta teste2');
INSERT INTO transactions (account_Id, transaction_value,type, category,from_who,notes) VALUES ('1','300', 'Revenue','Salary','Jonathan','First Transaction');
INSERT INTO transactions (account_Id, transaction_value,type, category,from_who,notes) VALUES ('2','500', 'Expense','Food','Bruno','Second Transaction');
