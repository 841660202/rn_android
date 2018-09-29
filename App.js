/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, {Component} from 'react';
import {
    AppRegistry,
    StyleSheet,
    Text,
    DeviceEventEmitter,
    NativeModules,
    View
} from 'react-native';

export default class ywq extends Component {

    componentWillMount() {
        //监听事件名为EventName的事件
        DeviceEventEmitter.addListener('EventName', function () {


            alert("send success");

        });


    }

    constructor(props) {
        super(props);
        this.state = {
            content: '这个是预定的接受信息',
        }
    }

    render() {
        return (
            <View style={styles.container}>

                <Text style={styles.welcome}
                      onPress={this.callNative.bind(this)}
                >
                    当你点我的时候会调用原生方法，原生方法延迟3s后会向前端发送事件。
                    前端一直在监听该事件，如果收到，则给出alert提示!
                </Text>

                <Text style={styles.welcome}>
                    {this.state.content}
                </Text>
                <Text style={styles.welcome}
                    //给此处的文字绑定一个事件，其中callNative为要调用的方法名。
                      onPress={this.callNativeTime.bind(this)}
                >
                    callNativeTime!
                </Text>

                <Text style={styles.instructions}>
                    此Demo演示如何调用Android原生中的复杂方法。
                </Text>
                <Text style={styles.welcome}
                    //给此处的文字绑定一个事件，其中callNative为要调用的方法名。
                      onPress={this.sendMsg2Android.bind(this)}
                >

                    rn 给原生传值
                </Text>
                <Text style={styles.welcome}
                    //给此处的文字绑定一个事件，其中callNative为要调用的方法名。
                      onPress={this.update.bind(this)}
                >

                    调用原生升级
                </Text>
                <Text style={styles.welcome}
                    //给此处的文字绑定一个事件，其中callNative为要调用的方法名。
                      onPress={this.dirUpdate.bind(this)}
                >

                    调用原生升级
                </Text>
            </View>
        );
    }

    callNative() {
        NativeModules.MyModule.NativeMethod();
    }

    callNativeTime() {
        NativeModules.MyModule.showTime();
    }

    sendMsg2Android() {
        NativeModules.MyModule.showToast('你好Android，我是RN');
    }
    update() {
        NativeModules.MyModule.update('https://raw.githubusercontent.com/WVector/AppUpdateDemo/master/json/json1.txt');
    }
    dirUpdate() {
        NativeModules.MyModule.dirUpdate('https://raw.githubusercontent.com/WVector/AppUpdateDemo/master/json/json1.txt');
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#F5FCFF',
    },
    welcome: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
    instructions: {
        textAlign: 'center',
        color: '#333333',
        marginBottom: 5,
    },
});

AppRegistry.registerComponent('rn_android', () => ywq);
