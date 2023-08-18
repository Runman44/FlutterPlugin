import 'package:animated_flip_counter/animated_flip_counter.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

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
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  double _value = 0.0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        leading: IconButton(
          onPressed: () {
            SystemNavigator.pop();
          },
          icon: const Icon(Icons.arrow_back_rounded),
        ),
        title: Text(widget.title),
      ),
      body: Center(
        child: SingleChildScrollView(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              AnimatedFlipCounter(
                value: _value + 636.04,
                duration: const Duration(seconds: 2),
                fractionDigits: 2,
                thousandSeparator: ',',
                textStyle:
                    TextStyle(fontSize: 60, color: Colors.amber, fontWeight: FontWeight.w700),
              ),
              TextField(),
              TextField(),
              TextField(),
              TextField(),
              TextField(),
              TextField(),
              TextField(),
              TextField(),
              TextField(),
              TextField(),
            ],
          ),
        ),
      ),
    );
  }
}
