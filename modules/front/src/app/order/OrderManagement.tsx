import * as React from "react";
import { RouteComponentProps } from "react-router";
import { observer } from "mobx-react";
import OrderEdit from "./OrderEdit";
import OrderList from "./OrderList";

type Props = RouteComponentProps<{ entityId?: string }>;

@observer
export class OrderManagement extends React.Component<Props> {
  static PATH = "/orderManagement";
  static NEW_SUBPATH = "new";

  render() {
    const { entityId } = this.props.match.params;
    return <>{entityId ? <OrderEdit entityId={entityId} /> : <OrderList />}</>;
  }
}
