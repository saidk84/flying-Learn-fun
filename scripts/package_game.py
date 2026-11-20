from pathlib import Path
root=Path(__file__).resolve().parents[1]
html=(root/"src/index.html").read_text()
for marker,file in [("STYLE","style.css"),("DATA","data.js"),("GAME","game.js")]:
 html=html.replace("/* "+marker+" */",(root/"src"/file).read_text())
for path in [root/"index.html",root/"android/app/src/main/assets/index.html"]:
 path.parent.mkdir(parents=True,exist_ok=True);path.write_text(html)
print(f"Packaged Flying: Learn & Fun ({len(html):,} characters)")
