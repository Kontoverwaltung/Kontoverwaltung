# Kontoverwaltung
Projekt für die DHBW Karlsruhe (Software Engineering II)

## Dokumentation
https://docs.google.com/document/d/1buIXHOe2Z0DWsPSzkP6k-NTj5DXlzBTd9wBLWem7mdA/edit

<br/>

## Befehle
```
BANK CREATE testbank1
```
`SUCCESS: bank created`
<br/><br/>

```
KUNDE CREATE testbank1 Peter Maier
```
`SUCCESS: created c34880fc-0941-4ff2-b018-d2ec117f8e9c`
<br/><br/>

```
KONTO CREATE testbank1 c34880fc-0941-4ff2-b018-d2ec117f8e9c 4722
```
`SUCCESS: konto c176ac7d-2c2a-4b0a-9a57-56bd75930dc6 created`
<br/><br/>

```
KONTO CHANGEPIN c176ac7d-2c2a-4b0a-9a57-56bd75930dc6 4722 2147
```
`SUCCESS: pin changed`
<br/><br/>


