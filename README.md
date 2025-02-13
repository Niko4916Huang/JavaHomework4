初試，用剛學會的 "JAVA + MYSQL" 功能，將進銷存的 “進貨作業”，新做了一份。

功能包含五項：
1. 進貨作業
2. 報表作業
3. 基本資料作業
   1. 商 品
   2. 廠 商
   3. 員 工
每項作業都包含，新增，查詢，更新 的功能。
員工基本資料作業，有刪除 的功能。
報表作業，有列印  的功能。

JAVA 技巧運用：

1, 商品編號，廠商編號 的 "重複建立" 保護。
   1.  在輸入的欄位上，增加檢查機制。
      
          Titemno = new JTextField();
      		Titemno.addFocusListener(new FocusAdapter() {       

           @Override       
      			public void focusLost(FocusEvent e) {       
      				String sItemno = Titemno.getText().trim();       
      				Item thisItem = new ItemServiceImpl().findByItemno(sItemno);       
      				if(thisItem != null)       
      				{       
      					Tool.alert(" 商品編號已存在， 請重新輸入！");      
      				}             				
      			}       
      		});
       
  2. 在 “新增” 按鍵上，再加檢查機制。

     // check itemno     
        String Itemno=Titemno.getText();     
        if(new ItemServiceImpl().isItemnoBeenUse(Itemno))     
        {     
           Tool.alert(" 商品編號 已被使用， 請重新輸入！");     
        }     
        else     
        {     
          String Item_no=Titemno.getText();     
          String item_name=Tname.getText();     
          int Item_cost=Integer.parseInt(Tcost.getText());     
          int item_price=Integer.parseInt(Tprice.getText());     
          String Item_factoryno=Tfactoryno.getText();     
          int item_qty=Integer.parseInt(Tqty.getText());     						
          Item oneitem = new Item(Item_no, item_name, Item_cost, item_price, Item_factoryno, item_qty );     
          new ItemServiceImpl().addItem(oneitem);
     
          Tool.alert(" 商品， 新增成功！");     
        }    

  4. 運用 mysql - JOIN 指令，產生報表所需的 DATA

     String 	SQL="select ";
          
				SQL += "received.indate,";

				SQL += "received.itemno, ";

				SQL += "item.itemname, ";

				SQL += "received.factoryno, ";

				SQL += "item.cost, ";

				SQL += "item.price, ";

				SQL += "received.inqty ";

				SQL += "FROM received INNER JOIN item ";

				SQL += "ON  item.itemno =received.itemno ";

				SQL += "WHERE indate >= ? and indate <= ? ";

				SQL += "ORDER BY received.indate, received.itemno ";


總結：

    經過本次的實作，初窺 JAVA 的世界，發現有很多地方可以去學習運用。
    
    慢慢地思考，利用 JAVA 再開創一個世界。
    
