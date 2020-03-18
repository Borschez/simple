INSERT INTO BaseExpressionAction (name, description, evaluateExpression, executionExpression, active) VALUES
  ('Add Space', 'Simply add space to the end of string', 'getModifiedString().length() > 0', 'getModifiedString()', false),
  ('Show Owner', 'Simply show object owner field', 'getOwner().length() > 0', 'getOwner()', true);
commit;
