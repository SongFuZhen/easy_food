import * as React from "react";
import { RouteComponentProps } from "react-router";
import { observer } from "mobx-react";
import ShopEdit from "./ShopEdit";
import ShopList from "./ShopList";

type Props = RouteComponentProps<{ entityId?: string }>;

@observer
export class ShopManagement extends React.Component<Props> {
  static PATH = "/shopManagement";
  static NEW_SUBPATH = "new";

  render() {
    const { entityId } = this.props.match.params;
    return <>{entityId ? <ShopEdit entityId={entityId} /> : <ShopList />}</>;
  }
}
