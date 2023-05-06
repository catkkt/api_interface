import { PageContainer } from '@ant-design/pro-components';
import {Button, Card, Descriptions, Divider, Form, message, Spin} from 'antd';
import React, {useEffect, useState} from 'react';
import {
  getInterfaceInfoByIdUsingGET, invokeInterfaceInfoUsingPOST
} from "@/services/api-backend/interfaceInfoController";
import {useParams} from "@@/exports";
import Input from 'antd/lib/input';



/**
 * 主页
 * @constructor
 */
const Index: React.FC = () => {

    const [loading, setLoading] = useState(false);
    const [invokeLoading, setInvokeLoading] = useState(false);
    const [data, setData] = useState<API.InterfaceInfo>();
    const [invokeRes, setInvokeRes] = useState<any>();

    const params = useParams();

    const loadData = async () => {
      if(!params.id) {
        message.error('参数不存在');
        return;
      }
      setLoading(true);
      try {
        const res = await getInterfaceInfoByIdUsingGET({
          id: Number(params.id)
      });
        setData(res.data);
      }catch (error: any) {
        message.error('创建失败,'+ error.message);
      }
      setLoading(false);
    }

  useEffect( ()=> {
    loadData();
  },[])

  const onFinish = async (values: any) => {
      if(!params.id) {
        message.error('接口不存在');
        return;
      }
      setInvokeLoading(true);
    try {
      const res = await invokeInterfaceInfoUsingPOST({
        id: params.id,
        ...values,
      });
      setInvokeRes(res.data);
      message.success('请求成功')
    }catch (error: any) {
      message.error('请求失败,'+ error.message);
    }
    setInvokeLoading(false);
  };

  return (
    <PageContainer title="查看接口文档">
      <Card>

        {
          data ? (
            <Descriptions title={data.name} column={1} >
            <Descriptions.Item label="status">{data.status ? '正常' : '关闭'}</Descriptions.Item>
            <Descriptions.Item label="description">{data.description}</Descriptions.Item>
            <Descriptions.Item label="url">{data.url}</Descriptions.Item>
            <Descriptions.Item label="method">{data.method}</Descriptions.Item>
            <Descriptions.Item label="requestParams">{data.requestParams}</Descriptions.Item>
            <Descriptions.Item label="requestHeader">{data.requestHeader}</Descriptions.Item>
            <Descriptions.Item label="responseHeader">{data.responseHeader}</Descriptions.Item>
            <Descriptions.Item label="updateTime">{data.updateTime}</Descriptions.Item>
            <Descriptions.Item label="createTime">{data.createTime}</Descriptions.Item>
          </Descriptions>)
        : (<>接口不存在</>)
        }
      </Card>

      <Divider />
      <Card title="在线测试">
        <Form name="invoke" layout="vertical" onFinish={onFinish}>
          <Form.Item label="请求参数" name="userRequestParams">
            <Input.TextArea />
          </Form.Item>
          <Form.Item wrapperCol={{ span: 16 }}>
            <Button type="primary" htmlType="submit">
              调用
            </Button>
          </Form.Item>
        </Form>
      </Card>
      <Divider />
      <Card title="返回结果" loading={invokeLoading}>
        {invokeRes}
      </Card>

    </PageContainer>
  )
};

export default Index;
