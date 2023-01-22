# ユースケース
クリップボードのテキストに装飾

- メールの引用符付加  
- 区切り線の付加  
- 括弧付加  
- etc...  

> 例） あいうえお　→　>あいうえお  
> 例） あいうえお　→　「あいうえお」  
> 例） あいうえお　→　>あいうえお  
> 　　 かきくけこ　　　>かきくけこ  
> 　　 さしすせそ　　　>さしすせそ  



# 使用方法
1. 装飾したいテキストをコピーする
2. Decopy.exeを起動する -> ウィンドウが表示される
3. 装飾位置をリストから選択する
4. 装飾文字をテキストボックスに入力する
5. OKボタンを押す -> クリップボードに装飾後のテキストが保持される

※4で入力なしの場合Default=">"で装飾される  
※装飾を取りやめたい場合はCANCELボタンを押下する  



# コマンドライン引数（オプション）
- 装飾位置：デフォルト＝左  
    -p:[placement]

- 装飾文字：デフォルト＝'>'  
    -c:[decoString]

> 例）
java -jar Decopy.jar -p:UpDown -c:=

※よく使用する設定があれば上記コマンドをbatファイル化すると便利

# placementの種類
以下8種類

- Left(default) : 左  
- UpDown        : 上下  
- Up            : 上  
- LeftRight     : 左右  
- Brackets      : 括弧（左右）  
- Full          : 全囲（上下左右）
- Right         : 右
- Under         : 下

※指定なしの場合はLeft  
※Fullは文字幅のばらつきにより囲いがずれることが多い


# 制限
## 装飾文字の指定
以下の文字を装飾文字に指定する場合は **\（バックスラッシュ,osx）** or **^(キャレット,windows)** を前につけること。

- ( → -c:\\(  
- < → -c:\\<  
- << → -c:\\<\\<  
- [ → -c:\\[  
