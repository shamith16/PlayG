import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  static const platform = MethodChannel("player.flutter.app/player");

  String link = "";

  void _playNativeVideo() async {
    dynamic result = "Failed to play video";
    var playvideo;
    try {
      playvideo = await platform.invokeMethod('playVideo', {"link": link});
      print(playvideo);
      print("this is link: $link");
      setState(() {});
    } on PlatformException catch (_) {
      print(result);
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Padding(
              padding: const EdgeInsets.only(left: 8.0, right: 8.0, bottom: 10),
              child: TextField(
                decoration: const InputDecoration(
                  border: OutlineInputBorder(),
                  hintText: "Paste media link",
                ),
                onChanged: (value) => value=link,
                onSubmitted: (lin) {
                  link = lin;
                },
              ),
            ),
            TextButton(
                onPressed: () {
                  if (link != "") {
                    _playNativeVideo();
                  }
                },
                child: const Text("Play"))
          ],
        ),
      ),
    );
  }
}
